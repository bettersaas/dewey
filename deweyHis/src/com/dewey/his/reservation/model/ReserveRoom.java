package com.dewey.his.reservation.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RReserveRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reserve_room", schema = "dbo", catalog = "dewey")
public class ReserveRoom implements java.io.Serializable {

	// Fields
	private Long id;
	private Reservation reservation;


	//private Long reserveId;
	private Long roomId;

	// Constructors
	/** default constructor */
	public ReserveRoom() {
	}

	/** full constructor */
	public ReserveRoom(Long id, Long reserveId, Long roomId) {
		this.id = id;
		//this.reserveId = reserveId;
		this.roomId = roomId;
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
/*
	@Column(name = "reserveId", nullable = false, precision = 10, scale = 0)
	public Long getReserveId() {
		return this.reserveId;
	}

	public void setReserveId(Long reserveId) {
		this.reserveId = reserveId;
	}
*/
	@Column(name = "roomId", nullable = false, precision = 10, scale = 0)
	public Long getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reserveId")
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}