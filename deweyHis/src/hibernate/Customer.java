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
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer")
public class Customer implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String custName;
	private String sex;
	private String telephone;
	private String mobilephone;
	private String fax;
	private String idType;
	private String idNo;
	private String memberNo;
	private String custType;
	private Integer discount;
	private Double ration;
	private String remark;
	private Integer consumeCount;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(Mer mer, String custName, String sex, String telephone,
			String mobilephone, String fax, String idType, String idNo,
			String memberNo, String custType, Integer discount, Double ration,
			String remark, Integer consumeCount, Timestamp createTime) {
		this.mer = mer;
		this.custName = custName;
		this.sex = sex;
		this.telephone = telephone;
		this.mobilephone = mobilephone;
		this.fax = fax;
		this.idType = idType;
		this.idNo = idNo;
		this.memberNo = memberNo;
		this.custType = custType;
		this.discount = discount;
		this.ration = ration;
		this.remark = remark;
		this.consumeCount = consumeCount;
		this.createTime = createTime;
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

	@Column(name = "telephone", length = 50)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "mobilephone", length = 20)
	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(name = "fax", length = 20)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "id_type", length = 2)
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

	@Column(name = "member_no", length = 20)
	public String getMemberNo() {
		return this.memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Column(name = "cust_type", length = 1)
	public String getCustType() {
		return this.custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	@Column(name = "discount", precision = 5, scale = 0)
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "ration", precision = 10)
	public Double getRation() {
		return this.ration;
	}

	public void setRation(Double ration) {
		this.ration = ration;
	}

	@Column(name = "remark", length = 500)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "consume_count", precision = 5, scale = 0)
	public Integer getConsumeCount() {
		return this.consumeCount;
	}

	public void setConsumeCount(Integer consumeCount) {
		this.consumeCount = consumeCount;
	}

	@Column(name = "create_time", length = 23)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}