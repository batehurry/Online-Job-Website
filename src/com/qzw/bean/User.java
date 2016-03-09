package com.qzw.bean;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Role role;
	private String userName;
	@JSONField(serialize = false)
	private String userPwd;
	private String salt;
	private Jobhunter jobhunter;
	private Enterprise enterprise;
	private Date createDate;
	private Date updateDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Jobhunter getJobhunter() {
		return jobhunter;
	}
	public void setJobhunter(Jobhunter jobhunter) {
		this.jobhunter = jobhunter;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}