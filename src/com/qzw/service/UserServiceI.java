package com.qzw.service;

import java.io.Serializable;

import com.qzw.bean.Enterprise;
import com.qzw.bean.Jobhunter;
import com.qzw.bean.User;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：UserServiceI.java  </p>
 * <p> 类描述：用户的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月15日  上午12:22:54
 * @version 1.0
 */
public interface UserServiceI {
	
	/**
	 * <p> 方法名：saveUser </p>
	 * <p> 方法描述：注册求职者 </p>
	 * <p> 返回值：Serializable </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Serializable saveUser1(User user) throws Exception;
	
	/**
	 * <p> 方法名：saveUser2 </p>
	 * <p> 方法描述：注册企业 </p>
	 * <p> 返回值：Serializable </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Serializable saveUser2(User user) throws Exception;

	/**
	 * <p> 方法名：findUserById </p>
	 * <p> 方法描述：根据用户名查询用户 </p>
	 * <p> 返回值：User </p>
	 * @param username
	 * @return
	 * @throws Exception
	 */
	User findUserById(String username) throws Exception;
	
	/**
	 * <p> 方法名：updatePwd </p>
	 * <p> 方法描述：修改密码 </p>
	 * <p> 返回值：void </p>
	 * @param pwd
	 * @param user
	 * @throws Exception
	 */
	void updatePwd(String pwd, User user) throws Exception;
	
	/**
	 * <p> 方法名：updateUserInfo1 </p>
	 * <p> 方法描述：更新求职者信息 </p>
	 * <p> 返回值：void </p>
	 * @param jobhunter
	 * @throws Exception
	 */
	void updateUserInfo1(Jobhunter jobhunter) throws Exception;
	
	/**
	 * <p> 方法名：updateUserInfo2 </p>
	 * <p> 方法描述：更新用人单位信息 </p>
	 * <p> 返回值：void </p>
	 * @param enterprise
	 * @throws Exception
	 */
	void updateUserInfo2(Enterprise enterprise) throws Exception;

}
