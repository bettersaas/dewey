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
 * ChargeRuleSetting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "charge_rule_setting")
public class ChargeRuleSetting implements java.io.Serializable {

	// Fields

	private Long id;
	private Mer mer;
	private String column1;
	private String column2;
	private String column3;
	private String column4;
	private String column5;
	private String column6;
	private String column7;
	private String column8;
	private String column9;
	private String column10;
	private String column11;
	private String column12;
	private String column13;
	private String column14;

	// Constructors

	/** default constructor */
	public ChargeRuleSetting() {
	}

	/** full constructor */
	public ChargeRuleSetting(Mer mer, String column1, String column2,
			String column3, String column4, String column5, String column6,
			String column7, String column8, String column9, String column10,
			String column11, String column12, String column13, String column14) {
		this.mer = mer;
		this.column1 = column1;
		this.column2 = column2;
		this.column3 = column3;
		this.column4 = column4;
		this.column5 = column5;
		this.column6 = column6;
		this.column7 = column7;
		this.column8 = column8;
		this.column9 = column9;
		this.column10 = column10;
		this.column11 = column11;
		this.column12 = column12;
		this.column13 = column13;
		this.column14 = column14;
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

	@Column(name = "column1", length = 8)
	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	@Column(name = "column2", length = 8)
	public String getColumn2() {
		return this.column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	@Column(name = "column3", length = 8)
	public String getColumn3() {
		return this.column3;
	}

	public void setColumn3(String column3) {
		this.column3 = column3;
	}

	@Column(name = "column4", length = 8)
	public String getColumn4() {
		return this.column4;
	}

	public void setColumn4(String column4) {
		this.column4 = column4;
	}

	@Column(name = "column5", length = 8)
	public String getColumn5() {
		return this.column5;
	}

	public void setColumn5(String column5) {
		this.column5 = column5;
	}

	@Column(name = "column6", length = 8)
	public String getColumn6() {
		return this.column6;
	}

	public void setColumn6(String column6) {
		this.column6 = column6;
	}

	@Column(name = "column7", length = 8)
	public String getColumn7() {
		return this.column7;
	}

	public void setColumn7(String column7) {
		this.column7 = column7;
	}

	@Column(name = "column8", length = 8)
	public String getColumn8() {
		return this.column8;
	}

	public void setColumn8(String column8) {
		this.column8 = column8;
	}

	@Column(name = "column9", length = 8)
	public String getColumn9() {
		return this.column9;
	}

	public void setColumn9(String column9) {
		this.column9 = column9;
	}

	@Column(name = "column10", length = 8)
	public String getColumn10() {
		return this.column10;
	}

	public void setColumn10(String column10) {
		this.column10 = column10;
	}

	@Column(name = "column11", length = 8)
	public String getColumn11() {
		return this.column11;
	}

	public void setColumn11(String column11) {
		this.column11 = column11;
	}

	@Column(name = "column12", length = 8)
	public String getColumn12() {
		return this.column12;
	}

	public void setColumn12(String column12) {
		this.column12 = column12;
	}

	@Column(name = "column13", length = 8)
	public String getColumn13() {
		return this.column13;
	}

	public void setColumn13(String column13) {
		this.column13 = column13;
	}

	@Column(name = "column14", length = 8)
	public String getColumn14() {
		return this.column14;
	}

	public void setColumn14(String column14) {
		this.column14 = column14;
	}

}