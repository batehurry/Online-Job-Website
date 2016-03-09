package com.qzw.service.impl;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.Enterprise;
import com.qzw.bean.Jobhunter;
import com.qzw.bean.User;
import com.qzw.common.Constants;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TEnterprise;
import com.qzw.entity.TJobhunter;
import com.qzw.entity.TRole;
import com.qzw.entity.TUser;
import com.qzw.service.UserServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：UserServiceImpl.java  </p>
 * <p> 类描述：用户的Service实现类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:07:25
 * @version 1.0
 */
@Service
public class UserServiceImpl extends BaseService implements UserServiceI {

	@Autowired
	private BaseDaoI<TUser> userDao;
	
	@Autowired
	private BaseDaoI<TJobhunter> jobhunterDao;
	
	@Autowired
	private BaseDaoI<TEnterprise> enterpriseDao;
	
	@Autowired
	private BaseDaoI<TRole> roleDao;
	
	/* (non-Javadoc)
	 * @see com.qzw.service.UserServiceI#saveUser1(com.qzw.bean.User)
	 */
	@Override
	public Serializable saveUser1(User user) throws Exception {
		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = secureRandomNumberGenerator.nextBytes().toHex();
		//组合username,两次迭代，对密码进行加密,使用SHA-512算法加密
		String password =  new Sha512Hash(user.getUserPwd(), user.getUserName() + salt, 2).toHex();
		TUser tUser = changeModal(user, TUser.class);
		tUser.setCreateDate(new Date());
		tUser.setRole(roleDao.getByHql("from TRole where id = :id", getParamsMap("id", Constants.JOBHUNTER)));
		tUser.setSalt(salt);
		tUser.setUserPwd(password);
		TJobhunter tJobhunter = changeModal(user.getJobhunter(), TJobhunter.class);
		tJobhunter.setCreateDate(new Date());
		tUser.setJobhunter(tJobhunter);
		return userDao.save(tUser);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.UserServiceI#saveUser2(com.qzw.bean.User)
	 */
	@Override
	public Serializable saveUser2(User user) throws Exception {
		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = secureRandomNumberGenerator.nextBytes().toHex();
		//组合username,两次迭代，对密码进行加密,使用SHA-512算法加密
		String password =  new Sha512Hash(user.getUserPwd(), user.getUserName() + salt, 2).toHex();
		TUser tUser = changeModal(user, TUser.class);
		tUser.setCreateDate(new Date());
		tUser.setRole(roleDao.getByHql("from TRole where id = :id", getParamsMap("id", Constants.ENTERPRISE)));
		tUser.setSalt(salt);
		tUser.setUserPwd(password);
		TEnterprise tEnterprise = changeModal(user.getEnterprise(), TEnterprise.class);
		tEnterprise.setCreateDate(new Date());
		tUser.setEnterprise(tEnterprise);
		return userDao.save(tUser);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qzw.service.UserServiceI#findUserById(java.lang.String)
	 */
	@Override
	public User findUserById(String username) throws Exception {
		String hql = "from TUser t where t.userName = :username";
		return changeModal(userDao.getByHql(hql, getParamsMap("username", username)), User.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.UserServiceI#updatePwd(java.lang.String, com.qzw.bean.User)
	 */
	@Override
	public void updatePwd(String pwd, User user) throws Exception {
		SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
		String salt = secureRandomNumberGenerator.nextBytes().toHex();
		//组合username,两次迭代，对密码进行加密,使用SHA-512算法加密
		String password =  new Sha512Hash(pwd, user.getUserName() + salt, 2).toHex();
		user.setSalt(salt);
		user.setUserPwd(password);
		user.setUpdateDate(new Date());
		userDao.update(changeModal(user, TUser.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.UserServiceI#updateUserInfo1(com.qzw.bean.Jobhunter)
	 */
	@Override
	public void updateUserInfo1(Jobhunter jobhunter) throws Exception {
		jobhunter.setUpdateDate(new Date());
		jobhunterDao.update(changeModal(jobhunter, TJobhunter.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.UserServiceI#updateUserInfo2(com.qzw.bean.Enterprise)
	 */
	@Override
	public void updateUserInfo2(Enterprise enterprise) throws Exception {
		enterprise.setUpdateDate(new Date());
		enterpriseDao.update(changeModal(enterprise, TEnterprise.class));
	}

}