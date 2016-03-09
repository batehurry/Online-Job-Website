package com.qzw.bean;

import java.util.Date;

public class Vitae implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	private String id;
	/**
	 * 户口所在地
	 */
	private String householdAdd;
	/**
	 * 现居地
	 */
	private String presentAdd;
	/**
	 * 职位
	 */
	private Position position;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 头像
	 */
	private String favicon;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 意向薪资
	 */
	private Dict salary;
	/**
	 * 婚姻状况
	 */
	private Dict married;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 自我介绍
	 */
	private String selfEval;
	/**
	 * 性别
	 */
	private Dict sex;
	/**
	 * 身高
	 */
	private Integer stature;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 微信号
	 */
	private String weChat;
	/**
	 * 体重
	 */
	private Integer weight;
	/**
	 * 工作地址
	 */
	private String workAdd;
	/**
	 * 工作日期
	 */
	private Date workDate;
	/**
	 * 工作经历状态
	 */
	private Dict workExpState;
	/**
	 * 工作状态
	 */
	private Dict workState;
	/**
	 * 工作类型
	 */
	private Dict workType;
	/**
	 * 工作经验
	 */
	private WorkExp workExp;
	/**
	 * 教育经历
	 */
	private EducationExp educationExp;
	/**
	 * 用户
	 */
	private User user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHouseholdAdd() {
		return householdAdd;
	}
	public void setHouseholdAdd(String householdAdd) {
		this.householdAdd = householdAdd;
	}
	public String getPresentAdd() {
		return presentAdd;
	}
	public void setPresentAdd(String presentAdd) {
		this.presentAdd = presentAdd;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavicon() {
		return favicon;
	}
	public void setFavicon(String favicon) {
		this.favicon = favicon;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Dict getSalary() {
		return salary;
	}
	public void setSalary(Dict salary) {
		this.salary = salary;
	}
	public Dict getMarried() {
		return married;
	}
	public void setMarried(Dict married) {
		this.married = married;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSelfEval() {
		return selfEval;
	}
	public void setSelfEval(String selfEval) {
		this.selfEval = selfEval;
	}
	public Dict getSex() {
		return sex;
	}
	public void setSex(Dict sex) {
		this.sex = sex;
	}
	public Integer getStature() {
		return stature;
	}
	public void setStature(Integer stature) {
		this.stature = stature;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getWorkAdd() {
		return workAdd;
	}
	public void setWorkAdd(String workAdd) {
		this.workAdd = workAdd;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public Dict getWorkExpState() {
		return workExpState;
	}
	public void setWorkExpState(Dict workExpState) {
		this.workExpState = workExpState;
	}
	public Dict getWorkState() {
		return workState;
	}
	public void setWorkState(Dict workState) {
		this.workState = workState;
	}
	public Dict getWorkType() {
		return workType;
	}
	public void setWorkType(Dict workType) {
		this.workType = workType;
	}
	public WorkExp getWorkExp() {
		return workExp;
	}
	public void setWorkExp(WorkExp workExp) {
		this.workExp = workExp;
	}
	public EducationExp getEducationExp() {
		return educationExp;
	}
	public void setEducationExp(EducationExp educationExp) {
		this.educationExp = educationExp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}