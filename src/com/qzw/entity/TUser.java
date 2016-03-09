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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_user")
public class TUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private TRole role;
	private String userName;
	private String userPwd;
	private String salt;
	private TJobhunter jobhunter;
	private TEnterprise enterprise;
	private Date createDate;
	private Date updateDate;
	private Set<TPublishPosition> publishPositions = new HashSet<TPublishPosition>(0);
    private Set<TWorkExp> workExps = new HashSet<TWorkExp>(0);
    private Set<TEducationExp> educationExps = new HashSet<TEducationExp>(0);
    private Set<TVitae> vitaes = new HashSet<TVitae>(0);

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	public TRole getRole() {
		return this.role;
	}

	public void setRole(TRole role) {
		this.role = role;
	}

	@Column(name = "userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "userPwd")
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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

	@Column(name = "salt")
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "jobhunterId")
	public TJobhunter getJobhunter() {
		return jobhunter;
	}

	public void setJobhunter(TJobhunter jobhunter) {
		this.jobhunter = jobhunter;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "enterpriseId")
	public TEnterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(TEnterprise enterprise) {
		this.enterprise = enterprise;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	public Set<TPublishPosition> getPublishPositions() {
		return publishPositions;
	}

	public void setPublishPositions(Set<TPublishPosition> publishPositions) {
		this.publishPositions = publishPositions;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	public Set<TWorkExp> getWorkExps() {
		return workExps;
	}

	public void setWorkExps(Set<TWorkExp> workExps) {
		this.workExps = workExps;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	public Set<TEducationExp> getEducationExps() {
		return educationExps;
	}

	public void setEducationExps(Set<TEducationExp> educationExps) {
		this.educationExps = educationExps;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
	public Set<TVitae> getVitaes() {
		return vitaes;
	}

	public void setVitaes(Set<TVitae> vitaes) {
		this.vitaes = vitaes;
	}
	
}