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
 * Relief entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "relief")
public class Relief implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private Long surrenderorId;
	private String surrenderorName;
	private Long reliefId;
	private String reliefName;
	private Double balance;
	private Double income;
	private Double turnInMoney;
	private Double drawMoney;
	private Double accountDeposit;
	private String remark;
	private Double cashIncome;
	private Double subscriptionIncome;
	private Double creditCardIncome;
	private Double chequeIncome;
	private Double cardIncome;
	private Double otherIncome;
	private Timestamp startTime;
	private Timestamp endTime;

	// Constructors

	/** default constructor */
	public Relief() {
	}

	/** full constructor */
	public Relief(Mer mer, Long surrenderorId, String surrenderorName,
			Long reliefId, String reliefName, Double balance, Double income,
			Double turnInMoney, Double drawMoney, Double accountDeposit,
			String remark, Double cashIncome, Double subscriptionIncome,
			Double creditCardIncome, Double chequeIncome, Double cardIncome,
			Double otherIncome, Timestamp startTime, Timestamp endTime) {
		this.mer = mer;
		this.surrenderorId = surrenderorId;
		this.surrenderorName = surrenderorName;
		this.reliefId = reliefId;
		this.reliefName = reliefName;
		this.balance = balance;
		this.income = income;
		this.turnInMoney = turnInMoney;
		this.drawMoney = drawMoney;
		this.accountDeposit = accountDeposit;
		this.remark = remark;
		this.cashIncome = cashIncome;
		this.subscriptionIncome = subscriptionIncome;
		this.creditCardIncome = creditCardIncome;
		this.chequeIncome = chequeIncome;
		this.cardIncome = cardIncome;
		this.otherIncome = otherIncome;
		this.startTime = startTime;
		this.endTime = endTime;
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

	@Column(name = "surrenderor_id", precision = 10, scale = 0)
	public Long getSurrenderorId() {
		return this.surrenderorId;
	}

	public void setSurrenderorId(Long surrenderorId) {
		this.surrenderorId = surrenderorId;
	}

	@Column(name = "surrenderor_name", length = 20)
	public String getSurrenderorName() {
		return this.surrenderorName;
	}

	public void setSurrenderorName(String surrenderorName) {
		this.surrenderorName = surrenderorName;
	}

	@Column(name = "relief_id", precision = 10, scale = 0)
	public Long getReliefId() {
		return this.reliefId;
	}

	public void setReliefId(Long reliefId) {
		this.reliefId = reliefId;
	}

	@Column(name = "relief_name", length = 20)
	public String getReliefName() {
		return this.reliefName;
	}

	public void setReliefName(String reliefName) {
		this.reliefName = reliefName;
	}

	@Column(name = "balance", precision = 10)
	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Column(name = "income", precision = 10)
	public Double getIncome() {
		return this.income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	@Column(name = "turn_in_money", precision = 10)
	public Double getTurnInMoney() {
		return this.turnInMoney;
	}

	public void setTurnInMoney(Double turnInMoney) {
		this.turnInMoney = turnInMoney;
	}

	@Column(name = "draw_money", precision = 10)
	public Double getDrawMoney() {
		return this.drawMoney;
	}

	public void setDrawMoney(Double drawMoney) {
		this.drawMoney = drawMoney;
	}

	@Column(name = "account_deposit", precision = 10)
	public Double getAccountDeposit() {
		return this.accountDeposit;
	}

	public void setAccountDeposit(Double accountDeposit) {
		this.accountDeposit = accountDeposit;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "cash_income", precision = 10)
	public Double getCashIncome() {
		return this.cashIncome;
	}

	public void setCashIncome(Double cashIncome) {
		this.cashIncome = cashIncome;
	}

	@Column(name = "subscription_income", precision = 10)
	public Double getSubscriptionIncome() {
		return this.subscriptionIncome;
	}

	public void setSubscriptionIncome(Double subscriptionIncome) {
		this.subscriptionIncome = subscriptionIncome;
	}

	@Column(name = "credit_card_income", precision = 10)
	public Double getCreditCardIncome() {
		return this.creditCardIncome;
	}

	public void setCreditCardIncome(Double creditCardIncome) {
		this.creditCardIncome = creditCardIncome;
	}

	@Column(name = "cheque_income", precision = 10)
	public Double getChequeIncome() {
		return this.chequeIncome;
	}

	public void setChequeIncome(Double chequeIncome) {
		this.chequeIncome = chequeIncome;
	}

	@Column(name = "card_income", precision = 10)
	public Double getCardIncome() {
		return this.cardIncome;
	}

	public void setCardIncome(Double cardIncome) {
		this.cardIncome = cardIncome;
	}

	@Column(name = "other_income", precision = 10)
	public Double getOtherIncome() {
		return this.otherIncome;
	}

	public void setOtherIncome(Double otherIncome) {
		this.otherIncome = otherIncome;
	}

	@Column(name = "start_time", length = 23)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", length = 23)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}