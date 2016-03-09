package com.qzw.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qzw.bean.User;
import com.qzw.service.UserServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.shiro </p>
 * <p> 类名称：CustomRealm.java  </p>
 * <p> 类描述：自定义Shiro的Realm </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月8日  下午10:09:45
 * @version 1.0
 */
public class CustomRealm extends AuthorizingRealm {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserServiceI userService;

	// 设置realm的名称
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}

	// 认证的方法
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token是用户输入的用户名和密码
		// 从token中取出用户名和密码
		String username = (String) token.getPrincipal();
		// 根据用户输入的username从数据库查询
		User user = null;
		try {
			user = userService.findUserById(username);
			if(null == user) {
				return null;
			}
			// 将user设置simpleAuthenticatonInfo
			return new SimpleAuthenticationInfo(user, user.getUserPwd(), ByteSource.Util.bytes(username + user.getSalt()), this.getName());
		} catch (Exception e) {
			logger.error("根据用户输入的username从数据库查询出现异常", e);
			return null;
		}
	}
	
	// 授权的方法
	/* (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User userInfo = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addRole(userInfo.getRole().getId());
		return simpleAuthorizationInfo;
	}
	
	/**
	 * <p> 方法名：clearCached </p>
	 * <p> 方法描述：清除缓存 </p>
	 * <p> 返回值：void </p>
	 */
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

}