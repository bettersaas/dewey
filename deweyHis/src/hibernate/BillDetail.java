package hibernate;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BillDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bill_detail")
public class BillDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Long merId;
	private String roomNo;
	private String billNo;
	private String billType;
	private String direction;
	private String tallyType;
	private Double amount;
	private Timestamp lcd;

	// Constructors

	/** default constructor */
	public BillDetail() {
	}

	/** full constructor */
	public BillDetail(Long merId, String roomNo, String billNo,
			String billType, String direction, String tallyType, Double amount,
			Timestamp lcd) {
		this.merId = merId;
		this.roomNo = roomNo;
		this.billNo = billNo;
		this.billType = billType;
		this.direction = direction;
		this.tallyType = tallyType;
		this.amount = amount;
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

	@Column(name = "bill_type", length = 1)
	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	@Column(name = "direction", length = 1)
	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Column(name = "tally_type", length = 1)
	public String getTallyType() {
		return this.tallyType;
	}

	public void setTallyType(String tallyType) {
		this.tallyType = tallyType;
	}

	@Column(name = "amount", precision = 10)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "lcd", length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

}