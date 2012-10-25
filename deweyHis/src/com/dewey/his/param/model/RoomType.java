package com.dewey.his.param.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dewey.his.common.model.Mer;
import com.dewey.his.crm.model.MerContractualRelation;
import com.dewey.his.sys.model.MerRoom;

/**
 * RoomType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "room_type")
public class RoomType implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String name;
	private String roomTypeDesc;
	private String comment;
	private Double alldayPrice;
	private Double alldayPerHourPrice;
	private Double halfdayPrice;
	private Double halfdayPerHourPrice;
	private Integer hourMeasure;
	private Double hourPrice;
	private Double hourPerHourPrice;
	private Set<MerRoom> merRooms = new HashSet<MerRoom>(0);
	private Set<MerContractualRelation> merContractualRelations = new HashSet<MerContractualRelation>(
			0);

	// Constructors

	/** default constructor */
	public RoomType() {
	}

	/** full constructor */
	public RoomType(Mer mer, String name, String roomTypeDesc, String comment,
			Double alldayPrice, Double alldayPerHourPrice, Double halfdayPrice,
			Double halfdayPerHourPrice, Integer hourMeasure, Double hourPrice,
			Double hourPerHourPrice, Set<MerRoom> merRooms,
			Set<MerContractualRelation> merContractualRelations) {
		this.mer = mer;
		this.name = name;
		this.roomTypeDesc = roomTypeDesc;
		this.comment = comment;
		this.alldayPrice = alldayPrice;
		this.alldayPerHourPrice = alldayPerHourPrice;
		this.halfdayPrice = halfdayPrice;
		this.halfdayPerHourPrice = halfdayPerHourPrice;
		this.hourMeasure = hourMeasure;
		this.hourPrice = hourPrice;
		this.hourPerHourPrice = hourPerHourPrice;
		this.merRooms = merRooms;
		this.merContractualRelations = merContractualRelations;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "room_type_desc")
	public String getRoomTypeDesc() {
		return this.roomTypeDesc;
	}

	public void setRoomTypeDesc(String roomTypeDesc) {
		this.roomTypeDesc = roomTypeDesc;
	}

	@Column(name = "comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "allday_price", precision = 10)
	public Double getAlldayPrice() {
		return this.alldayPrice;
	}

	public void setAlldayPrice(Double alldayPrice) {
		this.alldayPrice = alldayPrice;
	}

	@Column(name = "allday_per_hour_price", precision = 10)
	public Double getAlldayPerHourPrice() {
		return this.alldayPerHourPrice;
	}

	public void setAlldayPerHourPrice(Double alldayPerHourPrice) {
		this.alldayPerHourPrice = alldayPerHourPrice;
	}

	@Column(name = "halfday_price", precision = 10)
	public Double getHalfdayPrice() {
		return this.halfdayPrice;
	}

	public void setHalfdayPrice(Double halfdayPrice) {
		this.halfdayPrice = halfdayPrice;
	}

	@Column(name = "halfday_per_hour_price", precision = 10)
	public Double getHalfdayPerHourPrice() {
		return this.halfdayPerHourPrice;
	}

	public void setHalfdayPerHourPrice(Double halfdayPerHourPrice) {
		this.halfdayPerHourPrice = halfdayPerHourPrice;
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

	@Column(name = "hour_per_hour_price", precision = 10)
	public Double getHourPerHourPrice() {
		return this.hourPerHourPrice;
	}

	public void setHourPerHourPrice(Double hourPerHourPrice) {
		this.hourPerHourPrice = hourPerHourPrice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roomType")
	public Set<MerRoom> getMerRooms() {
		return this.merRooms;
	}

	public void setMerRooms(Set<MerRoom> merRooms) {
		this.merRooms = merRooms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roomType")
	public Set<MerContractualRelation> getMerContractualRelations() {
		return this.merContractualRelations;
	}

	public void setMerContractualRelations(
			Set<MerContractualRelation> merContractualRelations) {
		this.merContractualRelations = merContractualRelations;
	}

}