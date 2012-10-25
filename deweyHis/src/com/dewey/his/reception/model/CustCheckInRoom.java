package com.dewey.his.reception.model;


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

/**
 * CustCheckInRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cust_check_in_room")
public class CustCheckInRoom implements java.io.Serializable {

	// Fields
	
	private Long id;
	private CheckIn checkIn;
	private Long merId;
	private String checkInType;
	private Long roomId;
	private String roomNo;
	private Long bedId;
	private String bedNo;
	private Double registPrice;
	private Double discount;
	private Double amount;
	private String remark;
	private Long merOnDutyUserId;
	private String merOnDutyUserName;
	private Timestamp lcd;
	private List<CustCheckInConsume> custCheckInConsumes = new ArrayList<CustCheckInConsume>(0);
	private List<Foregift> foregifts = new ArrayList<Foregift>(0);

	// Constructors

	/** default constructor */
	public CustCheckInRoom() {
	}

	/** full constructor */
	public CustCheckInRoom(CheckIn checkIn, Long merId, String checkInType,
			Long roomId, String roomNo, Long bedId, String bedNo,
			Double registPrice, String remark, Long merOnDutyUserId,
			String merOnDutyUserName, Timestamp lcd,
			List<CustCheckInConsume> custCheckInConsumes, List<Foregift> foregifts) {
		this.checkIn = checkIn;
		this.merId = merId;
		this.checkInType = checkInType;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.bedId = bedId;
		this.bedNo = bedNo;
		this.registPrice = registPrice;
		this.remark = remark;
		this.merOnDutyUserId = merOnDutyUserId;
		this.merOnDutyUserName = merOnDutyUserName;
		this.lcd = lcd;
		this.custCheckInConsumes = custCheckInConsumes;
		this.foregifts = foregifts;
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
	@JoinColumn(name = "cust_check_in_id")
	public CheckIn getCheckIn() {
		return this.checkIn;
	}

	public void setCheckIn(CheckIn checkIn) {
		this.checkIn = checkIn;
	}

	@Column(name = "mer_id", precision = 10, scale = 0)
	public Long getMerId() {
		return this.merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	@Column(name = "check_in_type", length = 1)
	public String getCheckInType() {
		return this.checkInType;
	}

	public void setCheckInType(String checkInType) {
		this.checkInType = checkInType;
	}

	@Column(name = "room_id", precision = 10, scale = 0)
	public Long getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	@Column(name = "room_no", length = 10)
	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "bed_id", precision = 10, scale = 0)
	public Long getBedId() {
		return this.bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	@Column(name = "bed_no", length = 10)
	public String getBedNo() {
		return this.bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	@Column(name = "regist_price", precision = 10)
	public Double getRegistPrice() {
		return this.registPrice;
	}

	public void setRegistPrice(Double registPrice) {
		this.registPrice = registPrice;
	}
	
	@Column(name = "discount", precision = 4)
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "amount", precision = 10)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "mer_on_duty_user_id", precision = 10, scale = 0)
	public Long getMerOnDutyUserId() {
		return this.merOnDutyUserId;
	}

	public void setMerOnDutyUserId(Long merOnDutyUserId) {
		this.merOnDutyUserId = merOnDutyUserId;
	}

	@Column(name = "mer_on_duty_user_name", length = 20)
	public String getMerOnDutyUserName() {
		return this.merOnDutyUserName;
	}

	public void setMerOnDutyUserName(String merOnDutyUserName) {
		this.merOnDutyUserName = merOnDutyUserName;
	}

	@Column(name = "lcd", updatable=false, insertable=false,  length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custCheckInRoom")
	@OrderBy("id")
	public List<CustCheckInConsume> getCustCheckInConsumes() {
		return this.custCheckInConsumes;
	}

	public void setCustCheckInConsumes(
			List<CustCheckInConsume> custCheckInConsumes) {
		this.custCheckInConsumes = custCheckInConsumes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "custCheckInRoom")
	@OrderBy("lcd")
	public List<Foregift> getForegifts() {
		return this.foregifts;
	}

	public void setForegifts(List<Foregift> foregifts) {
		this.foregifts = foregifts;
	}

}