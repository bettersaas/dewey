package hibernate;

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

import com.dewey.his.common.model.Mer;

/**
 * Reservation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reservation")
public class ReservationOld implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String billNo;
	private String custName;
	private String sex;
	private Timestamp planArrivalDate;
	private Timestamp planDepartureDate;
	private Double price;
	private Integer discount;
	private Double discountPrice;
	private Integer persons;
	private Long contractualUnitId;
	private Long roomTypeId;
	private String memberNo;
	private String phone;
	private String status;
	private Timestamp reservationTime;

	// Constructors

	/** default constructor 
	public Reservation() {
	}
*/
	/** minimal constructor 
	public Reservation(Mer mer) {
		this.mer = mer;
	}
*/
	/** full constructor 
	public Reservation(Mer mer, String billNo, String custName, String sex,
			Timestamp planArrivalDate, Timestamp planDepartureDate,
			Double price, Integer discount, Double discountPrice,
			Integer persons, Long contractualUnitId, Long roomTypeId,
			String memberNo, String phone, String status,
			Timestamp reservationTime) {
		this.mer = mer;
		this.billNo = billNo;
		this.custName = custName;
		this.sex = sex;
		this.planArrivalDate = planArrivalDate;
		this.planDepartureDate = planDepartureDate;
		this.price = price;
		this.discount = discount;
		this.discountPrice = discountPrice;
		this.persons = persons;
		this.contractualUnitId = contractualUnitId;
		this.roomTypeId = roomTypeId;
		this.memberNo = memberNo;
		this.phone = phone;
		this.status = status;
		this.reservationTime = reservationTime;
	}
*/
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
	@JoinColumn(name = "mer_id", nullable = false)
	public Mer getMer() {
		return this.mer;
	}

	public void setMer(Mer mer) {
		this.mer = mer;
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

	@Column(name = "plan_arrival_date", length = 23)
	public Timestamp getPlanArrivalDate() {
		return this.planArrivalDate;
	}

	public void setPlanArrivalDate(Timestamp planArrivalDate) {
		this.planArrivalDate = planArrivalDate;
	}

	@Column(name = "plan_departure_date", length = 23)
	public Timestamp getPlanDepartureDate() {
		return this.planDepartureDate;
	}

	public void setPlanDepartureDate(Timestamp planDepartureDate) {
		this.planDepartureDate = planDepartureDate;
	}

	@Column(name = "price", precision = 10)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
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
	public Double getDiscountPrice() {
		return this.discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Column(name = "persons", precision = 5, scale = 0)
	public Integer getPersons() {
		return this.persons;
	}

	public void setPersons(Integer persons) {
		this.persons = persons;
	}

	@Column(name = "contractual_unit_id", precision = 10, scale = 0)
	public Long getContractualUnitId() {
		return this.contractualUnitId;
	}

	public void setContractualUnitId(Long contractualUnitId) {
		this.contractualUnitId = contractualUnitId;
	}

	@Column(name = "room_type_id", precision = 10, scale = 0)
	public Long getRoomTypeId() {
		return this.roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	@Column(name = "member_no", length = 20)
	public String getMemberNo() {
		return this.memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "status", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "reservation_time", length = 23)
	public Timestamp getReservationTime() {
		return this.reservationTime;
	}

	public void setReservationTime(Timestamp reservationTime) {
		this.reservationTime = reservationTime;
	}

}