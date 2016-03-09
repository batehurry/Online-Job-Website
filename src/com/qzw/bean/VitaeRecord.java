package com.qzw.bean;

import java.util.Date;

public class VitaeRecord implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private Vitae vitae;
	private PublishPosition publishPosition;
	private Dict readStatus;
	private Date readDate;
	private Dict recordResult;
	private Date interviewDate;
	private Date createDate;
	private Date updateDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Vitae getVitae() {
		return vitae;
	}
	public void setVitae(Vitae vitae) {
		this.vitae = vitae;
	}
	public PublishPosition getPublishPosition() {
		return publishPosition;
	}
	public void setPublishPosition(PublishPosition publishPosition) {
		this.publishPosition = publishPosition;
	}
	public Dict getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(Dict readStatus) {
		this.readStatus = readStatus;
	}
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	public Dict getRecordResult() {
		return recordResult;
	}
	public void setRecordResult(Dict recordResult) {
		this.recordResult = recordResult;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
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