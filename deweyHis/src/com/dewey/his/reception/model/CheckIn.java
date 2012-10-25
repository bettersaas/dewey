package com.dewey.his.reception.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.model.RoomType;

/**
 * CheckIn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "check_in")
public class CheckIn implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private RoomType roomType;
	private String billNo;
	private String custName;
	private String sex;
	private String idType;
	private String idNo;
	private String phone;
	private String address;
	private Integer peopleNum;
	private String stayType;
	private String settleMode;
	private Long contractualUnitId;
	private String contractualUnitName;
	private Integer breakfastTicket;
	private Integer discount;
	private String custType;
	private Timestamp arrivalDate;
	private Timestamp planDepartureDate;
	private Double stayDays;
	private Integer persons;
	private Double deposit;
	private String remark;
	private Long merOnDutyUserId;
	private String merOnDutyUserName;
	private String status;
	private Timestamp lcd;
	private List<ExchangeRoom> exchangeRooms = new ArrayList<ExchangeRoom>(0);
	private List<CustCheckInRoom> custCheckInRooms =  new ArrayList<CustCheckInRoom>(
			0);

	// Constructors

	/** default constructor */
	public CheckIn() {
	}

	/** full constructor */
	public CheckIn(Mer mer, RoomType roomType,String billNo, String custName, String sex,
			String idType, String idNo, String phone, String address,
			Integer peopleNum, String stayType, String settleMode,
			Long contractualUnitId, Integer breakfastTicket, Integer discount,
			String custType, Timestamp arrivalDate,
			Timestamp planDepartureDate, Double stayDays, Integer persons,
			Double deposit, String remark, Long merOnDutyUserId,
			String merOnDutyUserName, String status, Timestamp lcd,
			List<ExchangeRoom> exchangeRooms,
			List<CustCheckInRoom> custCheckInRooms) {
		this.mer = mer;
		this.roomType = roomType;
		this.billNo = billNo;
		this.custName = custName;
		this.sex = sex;
		this.idType = idType;
		this.idNo = idNo;
		this.phone = phone;
		this.address = address;
		this.peopleNum = peopleNum;
		this.stayType = stayType;
		this.settleMode = settleMode;
		this.contractualUnitId = contractualUnitId;
		this.breakfastTicket = breakfastTicket;
		this.discount = discount;
		this.custType = custType;
		this.arrivalDate = arrivalDate;
		this.planDepartureDate = planDepartureDate;
		this.stayDays = stayDays;
		this.persons = persons;
		this.deposit = deposit;
		this.remark = remark;
		this.merOnDutyUserId = merOnDutyUserId;
		this.merOnDutyUserName = merOnDutyUserName;
		this.status = status;
		this.lcd = lcd;
		this.exchangeRooms = exchangeRooms;
		this.custCheckInRooms = custCheckInRooms;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	public RoomType getRoomType() {
		return this.roomType;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	@Column(name = "bill_no", length = 20)
	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	@Column(name = "cust_name", length = 20)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "id_type", length = 1)
	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	@Column(name = "id_no", length = 20)
	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 120)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "people_num", precision = 5, scale = 0)
	public Integer getPeopleNum() {
		return this.peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	@Column(name = "stay_type", length = 1)
	public String getStayType() {
		return this.stayType;
	}

	public void setStayType(String stayType) {
		this.stayType = stayType;
	}

	@Column(name = "settle_mode", length = 2)
	public String getSettleMode() {
		return this.settleMode;
	}

	public void setSettleMode(String settleMode) {
		this.settleMode = settleMode;
	}

	@Column(name = "contractual_unit_id", precision = 10, scale = 0)
	public Long getContractualUnitId() {
		return this.contractualUnitId;
	}

	public void setContractualUnitId(Long contractualUnitId) {
		this.contractualUnitId = contractualUnitId;
	}

	@Column(name = "breakfast_ticket",  precision = 3, scale = 0)
	public Integer getBreakfastTicket() {
		return this.breakfastTicket;
	}

	public void setBreakfastTicket(Integer breakfastTicket) {
		this.breakfastTicket = breakfastTicket;
	}

	@Column(name = "discount", precision = 5, scale = 0)
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "cust_type", length = 2)
	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	@Column(name = "arrival_date", length = 23)
	public Timestamp getArrivalDate() {
		return this.arrivalDate;
	}

	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Column(name = "plan_departure_date", length = 23)
	public Timestamp getPlanDepartureDate() {
		return this.planDepartureDate;
	}

	public void setPlanDepartureDate(Timestamp planDepartureDate) {
		this.planDepartureDate = planDepartureDate;
	}

	@Column(name = "stay_days", precision = 5)
	public Double getStayDays() {
		return this.stayDays;
	}

	public void setStayDays(Double stayDays) {
		this.stayDays = stayDays;
	}

	@Column(name = "persons", precision = 5, scale = 0)
	public Integer getPersons() {
		return this.persons;
	}

	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	@Column(name = "deposit", precision = 10)
	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	@Column(name = "remark", length = 500)
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

	@Column(name = "status", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "lcd", updatable=false, insertable=false,  length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "checkIn")
	@OrderBy("id")
	public List<ExchangeRoom> getExchangeRooms() {
		return this.exchangeRooms;
	}

	@Column(name = "contractual_unit_name", length = 40)
	public String getContractualUnitName() {
		return contractualUnitName;
	}

	public void setContractualUnitName(String contractualUnitName) {
		this.contractualUnitName = contractualUnitName;
	}

	public void setExchangeRooms(List<ExchangeRoom> exchangeRooms) {
		this.exchangeRooms = exchangeRooms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "checkIn")
	@OrderBy("id")
	public List<CustCheckInRoom> getCustCheckInRooms() {
		return this.custCheckInRooms;
	}

	public void setCustCheckInRooms(List<CustCheckInRoom> custCheckInRooms) {
		this.custCheckInRooms = custCheckInRooms;
	}
}