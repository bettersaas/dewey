package com.dewey.his.reception.model;

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


/**
 * ExchangeRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exchange_room")
public class ExchangeRoom implements java.io.Serializable {

	// Fields

	private Long id;
	private CheckIn checkIn;
	private String oldRoomNo;
	private Double oldRoomNoPrice;
	private String roomNo;
	private Double roomNoPrice;
	private Timestamp exchangeTime;
	private String travler;

	// Constructors

	/** default constructor */
	public ExchangeRoom() {
	}

	/** full constructor */
	public ExchangeRoom(CheckIn checkIn, String oldRoomNo,
			Double oldRoomNoPrice, String roomNo, Double roomNoPrice,
			Timestamp exchangeTime, String travler) {
		this.checkIn = checkIn;
		this.oldRoomNo = oldRoomNo;
		this.oldRoomNoPrice = oldRoomNoPrice;
		this.roomNo = roomNo;
		this.roomNoPrice = roomNoPrice;
		this.exchangeTime = exchangeTime;
		this.travler = travler;
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
	@JoinColumn(name = "check_in_id")
	public CheckIn getCheckIn() {
		return this.checkIn;
	}

	public void setCheckIn(CheckIn checkIn) {
		this.checkIn = checkIn;
	}

	@Column(name = "old_room_no", length = 10)
	public String getOldRoomNo() {
		return this.oldRoomNo;
	}

	public void setOldRoomNo(String oldRoomNo) {
		this.oldRoomNo = oldRoomNo;
	}

	@Column(name = "old_room_no_price", precision = 10)
	public Double getOldRoomNoPrice() {
		return this.oldRoomNoPrice;
	}

	public void setOldRoomNoPrice(Double oldRoomNoPrice) {
		this.oldRoomNoPrice = oldRoomNoPrice;
	}

	@Column(name = "room_no", length = 10)
	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "room_no_price", precision = 10)
	public Double getRoomNoPrice() {
		return this.roomNoPrice;
	}

	public void setRoomNoPrice(Double roomNoPrice) {
		this.roomNoPrice = roomNoPrice;
	}

	@Column(name = "exchange_time", length = 23)
	public Timestamp getExchangeTime() {
		return this.exchangeTime;
	}

	public void setExchangeTime(Timestamp exchangeTime) {
		this.exchangeTime = exchangeTime;
	}

	@Column(name = "travler", length = 20)
	public String getTravler() {
		return this.travler;
	}

	public void setTravler(String travler) {
		this.travler = travler;
	}

}