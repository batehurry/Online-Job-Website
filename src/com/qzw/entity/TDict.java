package com.qzw.entity;

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
@Table(name = "t_dict")
public class TDict implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private TDictType dictType;
	private String name;
	private Set<TVitaeRecord> vitaeRecordsForRecordResult = new HashSet<TVitaeRecord>(0);
    private Set<TVitae> vitaesForSex = new HashSet<TVitae>(0);
    private Set<TEnterprise> enterprisesForType = new HashSet<TEnterprise>(0);
    private Set<TVitae> vitaesForWorkExpState = new HashSet<TVitae>(0);
    private Set<TVitae> vitaesForIntentionSalary = new HashSet<TVitae>(0);
    private Set<TPublishPosition> publishPositionsForSalary = new HashSet<TPublishPosition>(0);
    private Set<TJobhunter> jobhuntersForSex = new HashSet<TJobhunter>(0);
    private Set<TVitae> vitaesForWorkState = new HashSet<TVitae>(0);
    private Set<TVitae> vitaesForMarried = new HashSet<TVitae>(0);
    private Set<TVitaeRecord> vitaeRecordsForReadStatus = new HashSet<TVitaeRecord>(0);
    private Set<TVitae> vitaesForWorkType = new HashSet<TVitae>(0);

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
	@JoinColumn(name = "type")
	public TDictType getDictType() {
		return this.dictType;
	}

	public void setDictType(TDictType dictType) {
		this.dictType = dictType;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="recordResult")
	public Set<TVitaeRecord> getVitaeRecordsForRecordResult() {
		return vitaeRecordsForRecordResult;
	}

	public void setVitaeRecordsForRecordResult(Set<TVitaeRecord> vitaeRecordsForRecordResult) {
		this.vitaeRecordsForRecordResult = vitaeRecordsForRecordResult;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sex")
	public Set<TVitae> getVitaesForSex() {
		return vitaesForSex;
	}

	public void setVitaesForSex(Set<TVitae> vitaesForSex) {
		this.vitaesForSex = vitaesForSex;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="type")
	public Set<TEnterprise> getEnterprisesForType() {
		return enterprisesForType;
	}

	public void setEnterprisesForType(Set<TEnterprise> enterprisesForType) {
		this.enterprisesForType = enterprisesForType;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="workExpState")
	public Set<TVitae> getVitaesForWorkExpState() {
		return vitaesForWorkExpState;
	}

	public void setVitaesForWorkExpState(Set<TVitae> vitaesForWorkExpState) {
		this.vitaesForWorkExpState = vitaesForWorkExpState;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="salary")
	public Set<TVitae> getVitaesForIntentionSalary() {
		return vitaesForIntentionSalary;
	}

	public void setVitaesForIntentionSalary(Set<TVitae> vitaesForIntentionSalary) {
		this.vitaesForIntentionSalary = vitaesForIntentionSalary;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="salary")
	public Set<TPublishPosition> getPublishPositionsForSalary() {
		return publishPositionsForSalary;
	}

	public void setPublishPositionsForSalary(Set<TPublishPosition> publishPositionsForSalary) {
		this.publishPositionsForSalary = publishPositionsForSalary;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sex")
	public Set<TJobhunter> getJobhuntersForSex() {
		return jobhuntersForSex;
	}
	
	public void setJobhuntersForSex(Set<TJobhunter> jobhuntersForSex) {
		this.jobhuntersForSex = jobhuntersForSex;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="workState")
	public Set<TVitae> getVitaesForWorkState() {
		return vitaesForWorkState;
	}

	public void setVitaesForWorkState(Set<TVitae> vitaesForWorkState) {
		this.vitaesForWorkState = vitaesForWorkState;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="married")
	public Set<TVitae> getVitaesForMarried() {
		return vitaesForMarried;
	}

	public void setVitaesForMarried(Set<TVitae> vitaesForMarried) {
		this.vitaesForMarried = vitaesForMarried;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="readStatus")
	public Set<TVitaeRecord> getVitaeRecordsForReadStatus() {
		return vitaeRecordsForReadStatus;
	}

	public void setVitaeRecordsForReadStatus(Set<TVitaeRecord> vitaeRecordsForReadStatus) {
		this.vitaeRecordsForReadStatus = vitaeRecordsForReadStatus;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="workType")
	public Set<TVitae> getVitaesForWorkType() {
		return vitaesForWorkType;
	}

	public void setVitaesForWorkType(Set<TVitae> vitaesForWorkType) {
		this.vitaesForWorkType = vitaesForWorkType;
	}
	
}