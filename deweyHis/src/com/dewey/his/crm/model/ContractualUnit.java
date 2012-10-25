package com.dewey.his.crm.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.dewey.his.common.model.Mer;

/**
 * ContractualUnit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "contractual_unit")
public class ContractualUnit implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String company;
	private String linkman;
	private String address;
	private String telphone;
	private String fax;
	private String remark;
	private Timestamp createTime;
	private List<MerContractualRelation> merContractualRelations = new ArrayList<MerContractualRelation>(
			0);

	// Constructors

	/** default constructor */
	public ContractualUnit() {
	}

	/** full constructor */
	public ContractualUnit(Mer mer, String company, String linkman,String address,
			String telphone, String fax, String remark, Timestamp createTime,
			List<MerContractualRelation> merContractualRelations) {
		this.mer = mer;
		this.company = company;
		this.linkman = linkman;
		this.address = address;
		this.telphone = telphone;
		this.fax = fax;
		this.remark = remark;
		this.createTime = createTime;
		this.merContractualRelations = merContractualRelations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mer_id")
	public Mer getMer() {
		return this.mer;
	}

	public void setMer(Mer mer) {
		this.mer = mer;
	}

	@Column(name = "company", length = 40)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "linkman", length = 40)
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	@Column(name = "address", length = 120)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "telphone", length = 50)
	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "fax", length = 20)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "create_time", updatable=false, insertable=false, length = 23)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contractualUnit")
	@OrderBy("id")
	public List<MerContractualRelation> getMerContractualRelations() {
		return this.merContractualRelations;
	}

	public void setMerContractualRelations(
			List<MerContractualRelation> merContractualRelations) {
		this.merContractualRelations = merContractualRelations;
	}
}