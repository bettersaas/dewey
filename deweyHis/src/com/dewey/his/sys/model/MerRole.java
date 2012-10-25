package com.dewey.his.sys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dewey.his.common.model.Mer;

/**
 * MerRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mer_role")
public class MerRole implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String roleName;
	private String remark;
	private String readwrite;

	// Constructors

	/** default constructor */
	public MerRole() {
	}

	/** full constructor */
	public MerRole(Mer mer, String roleName, String remark, String readwrite) {
		this.mer = mer;
		this.roleName = roleName;
		this.remark = remark;
		this.readwrite = readwrite;
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

	@Column(name = "role_name", length = 20)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "remark", length = 20)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "readwrite", length = 300)
	public String getReadwrite() {
		return this.readwrite;
	}

	public void setReadwrite(String readwrite) {
		this.readwrite = readwrite;
	}

}