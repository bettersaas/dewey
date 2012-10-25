package hibernate;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CustCheckInPayBill entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cust_check_in_pay_bill")
public class CustCheckInPayBill implements java.io.Serializable {

	// Fields

	private Long id;
	private Long merId;
	private String roomNo;
	private String billNo;
	private String type;
	private Timestamp payTime;
	private String billType;
	private Double roomAmount;
	private Double servicesAmount;
	private Double amount;
	private Long merUserId;
	private String merUserName;
	private String payName;
	private String contractualUnitName;
	private Double refundment;
	private Double pay;
	private Double deposit;
	private String remark;
	private String splitStatus;
	private Timestamp splitTime;
	private Long parentPayBill;
	private String payStatus;
	private Timestamp lcd;

	// Constructors

	/** default constructor */
	public CustCheckInPayBill() {
	}

	/** full constructor */
	public CustCheckInPayBill(Long merId, String roomNo, String billNo,
			String type, Timestamp payTime, String billType, Double roomAmount,
			Double servicesAmount, Double amount, Long merUserId,
			String merUserName, String payName, String contractualUnitName,
			Double refundment, Double pay, Double deposit, String remark,
			String splitStatus, Timestamp splitTime, Long parentPayBill,
			String payStatus, Timestamp lcd) {
		this.merId = merId;
		this.roomNo = roomNo;
		this.billNo = billNo;
		this.type = type;
		this.payTime = payTime;
		this.billType = billType;
		this.roomAmount = roomAmount;
		this.servicesAmount = servicesAmount;
		this.amount = amount;
		this.merUserId = merUserId;
		this.merUserName = merUserName;
		this.payName = payName;
		this.contractualUnitName = contractualUnitName;
		this.refundment = refundment;
		this.pay = pay;
		this.deposit = deposit;
		this.remark = remark;
		this.splitStatus = splitStatus;
		this.splitTime = splitTime;
		this.parentPayBill = parentPayBill;
		this.payStatus = payStatus;
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

	@Column(name = "type", length = 2)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "pay_time", length = 23)
	public Timestamp getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	@Column(name = "bill_type", length = 1)
	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	@Column(name = "room_amount", precision = 10)
	public Double getRoomAmount() {
		return this.roomAmount;
	}

	public void setRoomAmount(Double roomAmount) {
		this.roomAmount = roomAmount;
	}

	@Column(name = "services_amount", precision = 10)
	public Double getServicesAmount() {
		return this.servicesAmount;
	}

	public void setServicesAmount(Double servicesAmount) {
		this.servicesAmount = servicesAmount;
	}

	@Column(name = "amount", precision = 10)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	@Column(name = "pay_name", length = 20)
	public String getPayName() {
		return this.payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	@Column(name = "contractual_unit_name", length = 40)
	public String getContractualUnitName() {
		return this.contractualUnitName;
	}

	public void setContractualUnitName(String contractualUnitName) {
		this.contractualUnitName = contractualUnitName;
	}

	@Column(name = "refundment", precision = 10)
	public Double getRefundment() {
		return this.refundment;
	}

	public void setRefundment(Double refundment) {
		this.refundment = refundment;
	}

	@Column(name = "pay", precision = 10)
	public Double getPay() {
		return this.pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	@Column(name = "deposit", precision = 10)
	public Double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "split_status", length = 1)
	public String getSplitStatus() {
		return this.splitStatus;
	}

	public void setSplitStatus(String splitStatus) {
		this.splitStatus = splitStatus;
	}

	@Column(name = "split_time", length = 23)
	public Timestamp getSplitTime() {
		return this.splitTime;
	}

	public void setSplitTime(Timestamp splitTime) {
		this.splitTime = splitTime;
	}

	@Column(name = "parent_pay_bill", precision = 10, scale = 0)
	public Long getParentPayBill() {
		return this.parentPayBill;
	}

	public void setParentPayBill(Long parentPayBill) {
		this.parentPayBill = parentPayBill;
	}

	@Column(name = "pay_status", length = 1)
	public String getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "lcd", length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

}