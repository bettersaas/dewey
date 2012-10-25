package com.dewey.his.sys.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MerUserLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mer_user_log")
public class MerUserLog implements java.io.Serializable {

	// Fields

	private Long id;
	private String oprType;
	private Long merUserId;
	private String merUseName;
	private Timestamp oprDate;

	// Constructors

	/** default constructor */
	public MerUserLog() {
	}

	/** full constructor */
	public MerUserLog(String oprType, Long merUserId, String merUseName,
			Timestamp oprDate) {
		this.oprType = oprType;
		this.merUserId = merUserId;
		this.merUseName = merUseName;
		this.oprDate = oprDate;
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

	@Column(name = "opr_type")
	public String getOprType() {
		return this.oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

	@Column(name = "mer_user_id", precision = 10, scale = 0)
	public Long getMerUserId() {
		return this.merUserId;
	}

	public void setMerUserId(Long merUserId) {
		this.merUserId = merUserId;
	}

	@Column(name = "mer_use_name", length = 20)
	public String getMerUseName() {
		return this.merUseName;
	}

	public void setMerUseName(String merUseName) {
		this.merUseName = merUseName;
	}

	@Column(name = "opr_date", length = 23)
	public Timestamp getOprDate() {
		return this.oprDate;
	}

	public void setOprDate(Timestamp oprDate) {
		this.oprDate = oprDate;
	}

}