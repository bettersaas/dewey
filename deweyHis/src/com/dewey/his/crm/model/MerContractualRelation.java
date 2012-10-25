package com.dewey.his.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dewey.his.param.model.RoomType;

/**
 * MerContractualRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mer_contractual_relation")
public class MerContractualRelation implements java.io.Serializable {

	// Fields

	private Long id;
	private ContractualUnit contractualUnit;
	private RoomType roomType;
	private Long merId;
	private Double contractualPrice;

	// Constructors

	/** default constructor */
	public MerContractualRelation() {
	}

	/** minimal constructor */
	public MerContractualRelation(ContractualUnit contractualUnit) {
		this.contractualUnit = contractualUnit;
	}

	/** full constructor */
	public MerContractualRelation(ContractualUnit contractualUnit,
			RoomType roomType, Long merId, Double contractualPrice) {
		this.contractualUnit = contractualUnit;
		this.roomType = roomType;
		this.merId = merId;
		this.contractualPrice = contractualPrice;
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
	@JoinColumn(name = "contractual_unit_id", nullable = false)
	public ContractualUnit getContractualUnit() {
		return this.contractualUnit;
	}

	public void setContractualUnit(ContractualUnit contractualUnit) {
		this.contractualUnit = contractualUnit;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_type_id")
	public RoomType getRoomType() {
		return this.roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Column(name = "mer_id", precision = 10, scale = 0)
	public Long getMerId() {
		return this.merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	@Column(name = "contractual_price", precision = 10)
	public Double getContractualPrice() {
		return this.contractualPrice;
	}

	public void setContractualPrice(Double contractualPrice) {
		this.contractualPrice = contractualPrice;
	}

}