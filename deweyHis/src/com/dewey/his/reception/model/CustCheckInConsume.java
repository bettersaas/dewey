package com.dewey.his.reception.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dewey.his.sys.model.MerServices;

/**
 * CustCheckInConsume entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cust_check_in_consume")
public class CustCheckInConsume implements java.io.Serializable {

	// Fields

	private Long id;
	private CustCheckInRoom custCheckInRoom;
	private MerServices merServices;
	private Long merId;
	private Integer scalar;
	private Double total;

	// Constructors

	/** default constructor */
	public CustCheckInConsume() {
	}

	/** full constructor */
	public CustCheckInConsume(CustCheckInRoom custCheckInRoom,
			MerServices merServices, Long merId, Integer scalar, Double total) {
		this.custCheckInRoom = custCheckInRoom;
		this.merServices = merServices;
		this.merId = merId;
		this.scalar = scalar;
		this.total = total;
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
	@JoinColumn(name = "cust_check_in_room_id")
	public CustCheckInRoom getCustCheckInRoom() {
		return this.custCheckInRoom;
	}

	public void setCustCheckInRoom(CustCheckInRoom custCheckInRoom) {
		this.custCheckInRoom = custCheckInRoom;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mer_services_id")
	public MerServices getMerServices() {
		return this.merServices;
	}

	public void setMerServices(MerServices merServices) {
		this.merServices = merServices;
	}

	@Column(name = "mer_id", precision = 10, scale = 0)
	public Long getMerId() {
		return this.merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	@Column(name = "scalar", precision = 5, scale = 0)
	public Integer getScalar() {
		return this.scalar;
	}

	public void setScalar(Integer scalar) {
		this.scalar = scalar;
	}

	@Column(name = "total", precision = 10)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}