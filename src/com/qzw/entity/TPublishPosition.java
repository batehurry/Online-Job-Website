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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_publish_position")
public class TPublishPosition implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private TPosition position;
	private String workAdd;
	private TUser user;
	private TDict salary;
	private Integer peopleNumber;
	private String info;
	private Date createDate;
	private Date updateDate;
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

	@Column(name = "workAdd")
	public String getWorkAdd() {
		return workAdd;
	}

	public void setWorkAdd(String workAdd) {
		this.workAdd = workAdd;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salary")
	public TDict getSalary() {
		return salary;
	}

	public void setSalary(TDict salary) {
		this.salary = salary;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "positionId")
	public TPosition getPosition() {
		return this.position;
	}

	public void setPosition(TPosition position) {
		this.position = position;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public TUser getUser() {
		return this.user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

	@Column(name = "info")
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	@Column(name = "peopleNumber")
	public Integer getPeopleNumber() {
		return this.peopleNumber;
	}

	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="publishPosition")
	public Set<TVitaeRecord> getVitaeRecords() {
		return vitaeRecords;
	}

	public void setVitaeRecords(Set<TVitaeRecord> vitaeRecords) {
		this.vitaeRecords = vitaeRecords;
	}
	
	

}