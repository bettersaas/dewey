package com.dewey.his.sys.model;

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
 * RoomBed entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room_bed")
public class RoomBed implements java.io.Serializable {

	// Fields

	private Long id;
	private MerRoom merRoom;
	private Long merId;
	private String bedNo;
	private String hourFlag;
	private Double alldayPrice;
	private Double halfdayPrice;
	private Integer hourMeasure;
	private Double hourPrice;
	private String useFlag;
	private String bedDesc;

	// Constructors

	/** default constructor */
	public RoomBed() {
	}

	/** full constructor */
	public RoomBed(MerRoom merRoom, Long merId, String bedNo,
			Double alldayPrice, Double halfdayPrice, Double hourPrice,
			Integer hourMeasure, String useFlag, String bedDesc) {
		this.merRoom = merRoom;
		this.merId = merId;
		this.bedNo = bedNo;
		this.alldayPrice = alldayPrice;
		this.halfdayPrice = halfdayPrice;
		this.hourPrice = hourPrice;
		this.hourMeasure = hourMeasure;
		this.useFlag = useFlag;
		this.bedDesc = bedDesc;
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
	@JoinColumn(name = "mer_room_id")
	public MerRoom getMerRoom() {
		return this.merRoom;
	}

	public void setMerRoom(MerRoom merRoom) {
		this.merRoom = merRoom;
	}

	@Column(name = "mer_id", precision = 10, scale = 0)
	public Long getMerId() {
		return this.merId;
	}

	public void setMerId(Long merId) {
		this.merId = merId;
	}

	@Column(name = "bed_no", length = 10)
	public String getBedNo() {
		return this.bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}


	@Column(name = "use_flag", length = 1)
	public String getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	@Column(name = "bed_desc", length = 50)
	public String getBedDesc() {
		return this.bedDesc;
	}

	public void setBedDesc(String bedDesc) {
		this.bedDesc = bedDesc;
	}
	
	@Column(name = "hour_flag", length = 20)
	public String getHourFlag() {
		return hourFlag;
	}

	public void setHourFlag(String hourFlag) {
		this.hourFlag = hourFlag;
	}
	
	@Column(name = "allday_price", precision = 10)
	public Double getAlldayPrice() {
		return this.alldayPrice;
	}

	public void setAlldayPrice(Double alldayPrice) {
		this.alldayPrice = alldayPrice;
	}

	@Column(name = "halfday_price", precision = 10)
	public Double getHalfdayPrice() {
		return this.halfdayPrice;
	}

	public void setHalfdayPrice(Double halfdayPrice) {
		this.halfdayPrice = halfdayPrice;
	}

	@Column(name = "hour_measure", precision = 5, scale = 0)
	public Integer getHourMeasure() {
		return this.hourMeasure;
	}

	public void setHourMeasure(Integer hourMeasure) {
		this.hourMeasure = hourMeasure;
	}

	@Column(name = "hour_price", precision = 10)
	public Double getHourPrice() {
		return this.hourPrice;
	}

	public void setHourPrice(Double hourPrice) {
		this.hourPrice = hourPrice;
	}
	
}