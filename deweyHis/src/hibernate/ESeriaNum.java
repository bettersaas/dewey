package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ESeriaNum entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "e_seriaNum", schema = "dbo", catalog = "dewey")
public class ESeriaNum implements java.io.Serializable {

	// Fields

	private long id;
	private long merId;
	private long numValue;
	private String numType;
	private long max;
	private long min;

	// Constructors

	/** default constructor */
	public ESeriaNum() {
	}

	/** full constructor */
	public ESeriaNum(long merId, long numValue, String numType, long max,
			long min) {
		this.merId = merId;
		this.numValue = numValue;
		this.numType = numType;
		this.max = max;
		this.min = min;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "mer_id", precision = 10, scale = 0)
	public long getMerId() {
		return this.merId;
	}

	public void setMerId(long merId) {
		this.merId = merId;
	}

	@Column(name = "num_value", precision = 10, scale = 0)
	public long getNumValue() {
		return this.numValue;
	}

	public void setNumValue(long numValue) {
		this.numValue = numValue;
	}

	@Column(name = "num_type", length = 1)
	public String getNumType() {
		return this.numType;
	}

	public void setNumType(String numType) {
		this.numType = numType;
	}

	@Column(name = "max", precision = 10, scale = 0)
	public long getMax() {
		return this.max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	@Column(name = "min", precision = 10, scale = 0)
	public long getMin() {
		return this.min;
	}

	public void setMin(long min) {
		this.min = min;
	}

}