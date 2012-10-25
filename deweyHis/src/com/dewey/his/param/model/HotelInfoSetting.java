package com.dewey.his.param.model;

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
 * HotelInfoSetting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel_info_setting")
public class HotelInfoSetting implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String title;
	private String settleAcountTail;
	private String foregiftTail;

	// Constructors

	/** default constructor */
	public HotelInfoSetting() {
	}

	/** full constructor */
	public HotelInfoSetting(Mer mer, String title, String settleAcountTail,
			String foregiftTail) {
		this.mer = mer;
		this.title = title;
		this.settleAcountTail = settleAcountTail;
		this.foregiftTail = foregiftTail;
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

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "settle_acount_tail")
	public String getSettleAcountTail() {
		return this.settleAcountTail;
	}

	public void setSettleAcountTail(String settleAcountTail) {
		this.settleAcountTail = settleAcountTail;
	}

	@Column(name = "foregift_tail")
	public String getForegiftTail() {
		return this.foregiftTail;
	}

	public void setForegiftTail(String foregiftTail) {
		this.foregiftTail = foregiftTail;
	}

}