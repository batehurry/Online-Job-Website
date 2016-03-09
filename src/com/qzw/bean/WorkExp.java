package com.qzw.bean;

import java.util.Date;

import javax.validation.constraints.Past;

import com.qzw.contrllor.validation.ValidGroup1;

public class WorkExp implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private User user;
	private String etpName;
	@Past(message="{workExp.startDate}", groups=ValidGroup1.class)
	private Date startDate;
	private Date endDate;
	private String info;
	private Date createDate;
	private Date updateDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEtpName() {
		return etpName;
	}
	public void setEtpName(String etpName) {
		this.etpName = etpName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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