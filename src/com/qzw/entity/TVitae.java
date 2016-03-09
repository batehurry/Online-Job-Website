package com.qzw.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_vitae")
public class TVitae implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String householdAdd;
	private String presentAdd;
	private TPosition position;
	private String title;
	private String name;
	private TDict sex;
	private Date birthday;
	private TDict workExpState;
	private Date workDate;
	private TDict workState;
	private String idCard;
	private TDict married;
	private Integer stature;
	private Integer weight;
	private String tel;
	private String email;
	private String weChat;
	private String selfEval;
	private TDict workType;
	private String workAdd;
	private TDict salary;
	private byte[] favicon;
	private Date createDate;
	private Date updateDate;
	private TWorkExp workExp;
	private TEducationExp educationExp;
	private TUser user;
	private Set<TVitaeRecord> vitaeRecords = new HashSet<TVitaeRecord>(0);
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "householdAdd")
	public String getHouseholdAdd() {
		return householdAdd;
	}

	public void setHouseholdAdd(String householdAdd) {
		this.householdAdd = householdAdd;
	}

	@Column(name = "presentAdd")
	public String getPresentAdd() {
		return presentAdd;
	}

	public void setPresentAdd(String presentAdd) {
		this.presentAdd = presentAdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position")
	public TPosition getPosition() {
		return this.position;
	}

	public void setPosition(TPosition position) {
		this.position = position;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sex")
	public TDict getSex() {
		return this.sex;
	}

	public void setSex(TDict sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workExpState")
	public TDict getWorkExpState() {
		return this.workExpState;
	}

	public void setWorkExpState(TDict workExpState) {
		this.workExpState = workExpState;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "workDate", length = 10)
	public Date getWorkDate() {
		return this.workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workState")
	public TDict getWorkState() {
		return this.workState;
	}

	public void setWorkState(TDict workState) {
		this.workState = workState;
	}

	@Column(name = "idCard")
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "married")
	public TDict getMarried() {
		return this.married;
	}

	public void setMarried(TDict married) {
		this.married = married;
	}

	@Column(name = "stature")
	public Integer getStature() {
		return this.stature;
	}

	public void setStature(Integer stature) {
		this.stature = stature;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "weChat")
	public String getWeChat() {
		return this.weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	@Column(name = "selfEval")
	public String getSelfEval() {
		return this.selfEval;
	}

	public void setSelfEval(String selfEval) {
		this.selfEval = selfEval;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workType")
	public TDict getWorkType() {
		return this.workType;
	}

	public void setWorkType(TDict workType) {
		this.workType = workType;
	}

	@Column(name = "workAdd")
	public String getWorkAdd() {
		return this.workAdd;
	}

	public void setWorkAdd(String workAdd) {
		this.workAdd = workAdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "intentionSalary")
	public TDict getSalary() {
		return this.salary;
	}

	public void setSalary(TDict salary) {
		this.salary = salary;
	}

	@Column(name = "favicon")
	public byte[] getFavicon() {
		return this.favicon;
	}

	public void setFavicon(byte[] favicon) {
		this.favicon = favicon;
	}

	@Column(name = "createDate", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "updateDate", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workExpId")
	public TWorkExp getWorkExp() {
		return workExp;
	}

	public void setWorkExp(TWorkExp workExp) {
		this.workExp = workExp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "educationExpId")
	public TEducationExp getEducationExp() {
		return educationExp;
	}

	public void setEducationExp(TEducationExp educationExp) {
		this.educationExp = educationExp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="vitae")
	public Set<TVitaeRecord> getVitaeRecords() {
		return vitaeRecords;
	}
	
	public void setVitaeRecords(Set<TVitaeRecord> vitaeRecords) {
		this.vitaeRecords = vitaeRecords;
	}
	
}