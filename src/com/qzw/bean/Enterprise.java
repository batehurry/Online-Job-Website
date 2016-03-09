package com.qzw.bean;

import java.util.Date;

public class Enterprise implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String enterpriseAdd;
	private Date createDate;
	private String info;
	private String name;
	private String tel;
	private Dict type;
	private Date updateDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEnterpriseAdd() {
		return enterpriseAdd;
	}
	public void setEnterpriseAdd(String enterpriseAdd) {
		this.enterpriseAdd = enterpriseAdd;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Dict getType() {
		return type;
	}
	public void setType(Dict type) {
		this.type = type;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}