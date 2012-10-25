package com.dewey.his.reservation.model;

import java.util.ArrayList;
import java.util.Date;
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
import org.hibernate.annotations.GenericGenerator;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.model.RoomType;
import com.dewey.his.reception.model.CustCheckInRoom;


/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reservation", schema = "dbo", catalog = "dewey")
public class Reservation implements java.io.Serializable {

	// Fields

	private long id;
	private Mer mer;
	private String billNo;
	private String custName;
	private String sex;
	private String phone;
	private Date planArrivalDate;
	private Date planDepartureDate;
	private double planStayDays;
	private Integer planPersons;
	private String reserveType;
	private double price;
	private Integer discount;
	private double discountPrice;
	private long contractualUnitId;
	//private long roomTypeId;
	private RoomType roomType;
	private String memberNo;
	private String reserveStatus;
	private long merOnDutyUserId;
	private Date reservationTime;
	private Date lcd;
	private List<ReserveRoom> reserveRooms =  new ArrayList<ReserveRoom>(0);
	// Constructors

	


	/** default constructor */
	public Reservation() {
	}

	/** minimal constructor */
	public Reservation(Mer mer) {
		this.mer = mer;
	}

	/** full constructor */
	public Reservation(Mer mer, String billNo, String custName, String sex,
			String phone, Date planArrivalDate, Date planDepartureDate,
			double planStayDays, Integer planPersons, String reserveType,
			double price, Integer discount, double discountPrice,
			long contractualUnitId, long roomTypeId, String memberNo,
			String reserveStatus, long merOnDutyUserId, Date reservationTime,
			Date lcd) {
		this.mer = mer;
		this.billNo = billNo;
		this.custName = custName;
		this.sex = sex;
		this.phone = phone;
		this.planArrivalDate = planArrivalDate;
		this.planDepartureDate = planDepartureDate;
		this.planStayDays = planStayDays;
		this.planPersons = planPersons;
		this.reserveType = reserveType;
		this.price = price;
		this.discount = discount;
		this.discountPrice = discountPrice;
		this.contractualUnitId = contractualUnitId;
		//this.roomTypeId = roomTypeId;
		this.memberNo = memberNo;
		this.reserveStatus = reserveStatus;
		this.merOnDutyUserId = merOnDutyUserId;
		this.reservationTime = reservationTime;
		this.lcd = lcd;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mer_id", nullable = false)
	public Mer getMer() {
		return this.mer;
	}

	public void setMer(Mer mer) {
		this.mer = mer;
	}

	@Column(name = "bill_no")
	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	@Column(name = "cust_name")
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "sex")
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "plan_arrival_date", length = 23)
	public Date getPlanArrivalDate() {
		return this.planArrivalDate;
	}

	public void setPlanArrivalDate(Date planArrivalDate) {
		this.planArrivalDate = planArrivalDate;
	}

	@Column(name = "plan_departure_date", length = 23)
	public Date getPlanDepartureDate() {
		return this.planDepartureDate;
	}

	public void setPlanDepartureDate(Date planDepartureDate) {
		this.planDepartureDate = planDepartureDate;
	}

	@Column(name = "plan_stay_days", precision = 10)
	public double getPlanStayDays() {
		return this.planStayDays;
	}

	public void setPlanStayDays(double planStayDays) {
		this.planStayDays = planStayDays;
	}

	@Column(name = "plan_persons", precision = 5, scale = 0)
	public Integer getPlanPersons() {
		return this.planPersons;
	}

	public void setPlanPersons(Integer planPersons) {
		this.planPersons = planPersons;
	}

	@Column(name = "reserve_type")
	public String getReserveType() {
		return this.reserveType;
	}

	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}

	@Column(name = "price", precision = 10)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "discount", precision = 5, scale = 0)
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "discount_price", precision = 10)
	public double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "contractual_unit_id", precision = 10, scale = 0)
	public long getContractualUnitId() {
		return this.contractualUnitId;
	}

	public void setContractualUnitId(long contractualUnitId) {
		this.contractualUnitId = contractualUnitId;
	}
/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	public long getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
*/
	@Column(name = "member_no")
	public String getMemberNo() {
		return this.memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Column(name = "reserve_status")
	public String getReserveStatus() {
		return this.reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	@Column(name = "mer_on_duty_user_id", precision = 10, scale = 0)
	public long getMerOnDutyUserId() {
		return this.merOnDutyUserId;
	}

	public void setMerOnDutyUserId(long merOnDutyUserId) {
		this.merOnDutyUserId = merOnDutyUserId;
	}

	@Column(name = "reservation_time", length = 23)
	public Date getReservationTime() {
		return this.reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	@Column(name = "lcd", length = 23)
	public Date getLcd() {
		return this.lcd;
	}

	public void setLcd(Date lcd) {
		this.lcd = lcd;
	}
	@Column(name = "room_type_id", length = 10)
	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reservation")
	@OrderBy("id")
	public List<ReserveRoom> getReserveRooms() {
		return reserveRooms;
	}

	public void setReserveRooms(List<ReserveRoom> reserveRooms) {
		this.reserveRooms = reserveRooms;
	}
}