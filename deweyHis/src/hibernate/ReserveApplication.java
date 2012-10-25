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
 * ReserveApplication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reserve_application")
public class ReserveApplication implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private Long merCustId;
	private String reserveType;
	private Timestamp reserveDate;
	private Timestamp reserveTimeout;
	private Timestamp planArrivalDate;
	private Timestamp planDepartureDate;
	private Double planStayDays;
	private Integer planPersons;
	private Double reserveDeposit;
	private Integer discount;
	private String remark;
	private Long merOnDutyUserId;
	private String merOnDutyUserName;
	private String reserveStatus;
	private Timestamp lcd;

	// Constructors

	/** default constructor */
	public ReserveApplication() {
	}

	/** full constructor */
	public ReserveApplication(Mer mer, Long merCustId, String reserveType,
			Timestamp reserveDate, Timestamp reserveTimeout,
			Timestamp planArrivalDate, Timestamp planDepartureDate,
			Double planStayDays, Integer planPersons, Double reserveDeposit,
			Integer discount, String remark, Long merOnDutyUserId,
			String merOnDutyUserName, String reserveStatus, Timestamp lcd) {
		this.mer = mer;
		this.merCustId = merCustId;
		this.reserveType = reserveType;
		this.reserveDate = reserveDate;
		this.reserveTimeout = reserveTimeout;
		this.planArrivalDate = planArrivalDate;
		this.planDepartureDate = planDepartureDate;
		this.planStayDays = planStayDays;
		this.planPersons = planPersons;
		this.reserveDeposit = reserveDeposit;
		this.discount = discount;
		this.remark = remark;
		this.merOnDutyUserId = merOnDutyUserId;
		this.merOnDutyUserName = merOnDutyUserName;
		this.reserveStatus = reserveStatus;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mer_id")
	public Mer getMer() {
		return this.mer;
	}

	public void setMer(Mer mer) {
		this.mer = mer;
	}

	@Column(name = "mer_cust_id", precision = 10, scale = 0)
	public Long getMerCustId() {
		return this.merCustId;
	}

	public void setMerCustId(Long merCustId) {
		this.merCustId = merCustId;
	}

	@Column(name = "reserve_type", length = 2)
	public String getReserveType() {
		return this.reserveType;
	}

	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}

	@Column(name = "reserve_date", length = 23)
	public Timestamp getReserveDate() {
		return this.reserveDate;
	}

	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}

	@Column(name = "reserve_timeout", length = 23)
	public Timestamp getReserveTimeout() {
		return this.reserveTimeout;
	}

	public void setReserveTimeout(Timestamp reserveTimeout) {
		this.reserveTimeout = reserveTimeout;
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

	@Column(name = "plan_stay_days", precision = 10)
	public Double getPlanStayDays() {
		return this.planStayDays;
	}

	public void setPlanStayDays(Double planStayDays) {
		this.planStayDays = planStayDays;
	}

	@Column(name = "plan_persons", precision = 5, scale = 0)
	public Integer getPlanPersons() {
		return this.planPersons;
	}

	public void setPlanPersons(Integer planPersons) {
		this.planPersons = planPersons;
	}

	@Column(name = "reserve_deposit", precision = 10)
	public Double getReserveDeposit() {
		return this.reserveDeposit;
	}

	public void setReserveDeposit(Double reserveDeposit) {
		this.reserveDeposit = reserveDeposit;
	}

	@Column(name = "discount", precision = 5, scale = 0)
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
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

	@Column(name = "reserve_status", length = 2)
	public String getReserveStatus() {
		return this.reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	@Column(name = "lcd", length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

}