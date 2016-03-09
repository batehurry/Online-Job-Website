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
@Table(name = "t_position")
public class TPosition implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private TIndustry industry;
	private Date createDate;
	private Date updateDate;
	private Set<TVitae> vitaes = new HashSet<TVitae>(0);
    private Set<TPublishPosition> publishPositions = new HashSet<TPublishPosition>(0);

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
	
	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "industryId")
	public TIndustry getIndustry() {
		return this.industry;
	}

	public void setIndustry(TIndustry industry) {
		this.industry = industry;
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

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="position")
	public Set<TVitae> getVitaes() {
		return vitaes;
	}

	public void setVitaes(Set<TVitae> vitaes) {
		this.vitaes = vitaes;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="position")
	public Set<TPublishPosition> getPublishPositions() {
		return publishPositions;
	}

	public void setPublishPositions(Set<TPublishPosition> publishPositions) {
		this.publishPositions = publishPositions;
	}
	
}