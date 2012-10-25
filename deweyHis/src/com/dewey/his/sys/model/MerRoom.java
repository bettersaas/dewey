package com.dewey.his.sys.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
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
import javax.persistence.Transient;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.model.RoomType;

/**
 * MerRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mer_room")
public class MerRoom implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private RoomType roomType;
	private String roomNo;
	private String building;
	private Integer floor;
	private String telExtension;
	private String telExteriorLine;
	private String doorCard;
	private Double addBedPrice;
	private String hireFlag;
	private Integer currBed;
	private Integer maxBed;
	private String state;
	private String stateDesc;
	private String hourFlag;
	private Double alldayPrice;
	private Double halfdayPrice;
	private Integer hourMeasure;
	private Double hourPrice;
	private String roomDesc;
	private List<RoomBed> roomBeds = new ArrayList<RoomBed>(0);

	// Constructors

	/** default constructor */
	public MerRoom() {
	}

	/** full constructor */
	public MerRoom(Mer mer, RoomType roomType, String roomNo, String building,
			Integer floor, String telExtension, String telExteriorLine,
			String doorCard, Double addBedPrice, String hireFlag,
			Integer currBed, Integer maxBed, String state, Double alldayPrice,
			Double halfdayPrice, Integer hourMeasure, Double hourPrice,
			String roomDesc, List<RoomBed> roomBeds) {
		this.mer = mer;
		this.roomType = roomType;
		this.roomNo = roomNo;
		this.building = building;
		this.floor = floor;
		this.telExtension = telExtension;
		this.telExteriorLine = telExteriorLine;
		this.doorCard = doorCard;
		this.addBedPrice = addBedPrice;
		this.hireFlag = hireFlag;
		this.currBed = currBed;
		this.maxBed = maxBed;
		this.state = state;
		this.alldayPrice = alldayPrice;
		this.halfdayPrice = halfdayPrice;
		this.hourMeasure = hourMeasure;
		this.hourPrice = hourPrice;
		this.roomDesc = roomDesc;
		this.roomBeds = roomBeds;
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

	@Column(name = "room_no", length = 10)
	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "building", length = 20)
	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "floor", precision = 5, scale = 0)
	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	@Column(name = "tel_extension", length = 20)
	public String getTelExtension() {
		return this.telExtension;
	}

	public void setTelExtension(String telExtension) {
		this.telExtension = telExtension;
	}

	@Column(name = "tel_exterior_line", length = 20)
	public String getTelExteriorLine() {
		return this.telExteriorLine;
	}

	public void setTelExteriorLine(String telExteriorLine) {
		this.telExteriorLine = telExteriorLine;
	}

	@Column(name = "door_card", length = 20)
	public String getDoorCard() {
		return this.doorCard;
	}

	public void setDoorCard(String doorCard) {
		this.doorCard = doorCard;
	}

	@Column(name = "add_bed_price", precision = 10)
	public Double getAddBedPrice() {
		return this.addBedPrice;
	}

	public void setAddBedPrice(Double addBedPrice) {
		this.addBedPrice = addBedPrice;
	}

	@Column(name = "hire_flag", length = 2)
	public String getHireFlag() {
		return this.hireFlag;
	}

	public void setHireFlag(String hireFlag) {
		this.hireFlag = hireFlag;
	}

	@Column(name = "curr_bed", precision = 5, scale = 0)
	public Integer getCurrBed() {
		return this.currBed;
	}

	public void setCurrBed(Integer currBed) {
		this.currBed = currBed;
	}

	@Column(name = "max_bed", precision = 5, scale = 0)
	public Integer getMaxBed() {
		return this.maxBed;
	}

	public void setMaxBed(Integer maxBed) {
		this.maxBed = maxBed;
	}

	@Column(name = "state",updatable=false, length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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

	@Column(name = "room_desc", length = 100)
	public String getRoomDesc() {
		return this.roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "merRoom")
	@OrderBy("id")
	public List<RoomBed> getRoomBeds() {
		return this.roomBeds;
	}

	public void setRoomBeds(List<RoomBed> roomBeds) {
		this.roomBeds = roomBeds;
	}

	@Column(name = "hour_flag", length = 20)
	public String getHourFlag() {
		return hourFlag;
	}

	public void setHourFlag(String hourFlag) {
		this.hourFlag = hourFlag;
	}

	@Transient
	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
}