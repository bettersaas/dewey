package com.dewey.his.reception.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Foregift entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "foregift")
public class Foregift implements java.io.Serializable {

	// Fields

	private Long id;
	private Long merId;
	private CustCheckInRoom custCheckInRoom;
	private String roomNo;
	private String billNo;
	private String payNo;
	private Double payAmount;
	private Integer extendDays;
	private String remark;
	private Long merUserId;
	private String merUserName;
	private String payType;
	private Timestamp lcd;

	// Constructors

	/** default constructor */
	public Foregift() {
	}

	/** full constructor */
	public Foregift(CustCheckInRoom custCheckInRoom, String roomNo,
			String billNo, String payNo, Double payAmount, Integer extendDays,
			String remark, Long merUserId, String merUserName, String payType,
			Timestamp lcd) {
		this.custCheckInRoom = custCheckInRoom;
		this.roomNo = roomNo;
		this.billNo = billNo;
		this.payNo = payNo;
		this.payAmount = payAmount;
		this.extendDays = extendDays;
		this.remark = remark;
		this.merUserId = merUserId;
		this.merUserName = merUserName;
		this.payType = payType;
		this.lcd = lcd;
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
	
	@Column(name = "mer_id", precision = 10, scale = 0)
	public Long getMerId() {
		return this.merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_check_in_room_id")
	public CustCheckInRoom getCustCheckInRoom() {
		return this.custCheckInRoom;
	}

	public void setCustCheckInRoom(CustCheckInRoom custCheckInRoom) {
		this.custCheckInRoom = custCheckInRoom;
	}

	@Column(name = "room_no", length = 10)
	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "bill_no", length = 20)
	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	@Column(name = "pay_no", length = 20)
	public String getPayNo() {
		return this.payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	@Column(name = "pay_amount", precision = 10)
	public Double getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	@Column(name = "extend_days", precision = 5, scale = 0)
	public Integer getExtendDays() {
		return this.extendDays;
	}

	public void setExtendDays(Integer extendDays) {
		this.extendDays = extendDays;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "mer_user_id", precision = 10, scale = 0)
	public Long getMerUserId() {
		return this.merUserId;
	}

	public void setMerUserId(Long merUserId) {
		this.merUserId = merUserId;
	}

	@Column(name = "mer_user_name", length = 20)
	public String getMerUserName() {
		return this.merUserName;
	}

	public void setMerUserName(String merUserName) {
		this.merUserName = merUserName;
	}

	@Column(name = "pay_type", length = 2)
	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Column(name = "lcd", length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

}