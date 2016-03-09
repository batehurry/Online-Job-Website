package com.qzw.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_vitae_record")
public class TVitaeRecord implements java.io.Serializable {

	private static final long serialVersionUID = 1L;	
	
	private String id;
	private TVitae vitae;
	private TPublishPosition publishPosition;
	private TDict readStatus;
	private Date readDate;
	private TDict recordResult;
	private Date interviewDate;
	private Date createDate;
	private Date updateDate;
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vitaeId")
	public TVitae getVitae() {
		return vitae;
	}
	
	public void setVitae(TVitae vitae) {
		this.vitae = vitae;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publishPositionId")
	public TPublishPosition getPublishPosition() {
		return publishPosition;
	}
	
	public void setPublishPosition(TPublishPosition publishPosition) {
		this.publishPosition = publishPosition;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "readStatus")
	public TDict getReadStatus() {
		return readStatus;
	}
	
	public void setReadStatus(TDict readStatus) {
		this.readStatus = readStatus;
	}
	
	@Column(name = "readDate", length = 19)
	public Date getReadDate() {
		return readDate;
	}
	
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recordResult")
	public TDict getRecordResult() {
		return recordResult;
	}
	
	public void setRecordResult(TDict recordResult) {
		this.recordResult = recordResult;
	}

	@Column(name = "interviewDate", length = 19)
	public Date getInterviewDate() {
		return interviewDate;
	}
	
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	
	@Column(name = "createDate", length = 19)
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "updateDate", length = 19)
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}