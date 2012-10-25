package com.dewey.his.sys.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dewey.his.reception.model.CustCheckInConsume;

/**
 * MerServices entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mer_services")
public class MerServices implements java.io.Serializable {

	// Fields

	private Long id;
	private Long merId;
	private String name;
	private Double price;
	private String consumeType;
	private String consumeUnit;
	private String servicesDesc;
	private Set<CustCheckInConsume> custCheckInConsumes = new HashSet<CustCheckInConsume>(
			0);

	// Constructors

	/** default constructor */
	public MerServices() {
	}

	/** full constructor */
	public MerServices(Long merId, String name, Double price,
			String consumeType, String consumeUnit, String servicesDesc,
			Set<CustCheckInConsume> custCheckInConsumes) {
		this.merId = merId;
		this.name = name;
		this.price = price;
		this.consumeType = consumeType;
		this.consumeUnit = consumeUnit;
		this.servicesDesc = servicesDesc;
		this.custCheckInConsumes = custCheckInConsumes;
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

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 10)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "consume_type", length = 2)
	public String getConsumeType() {
		return this.consumeType;
	}

	public void setConsumeType(String consumeType) {
		this.consumeType = consumeType;
	}

	@Column(name = "consume_unit", length = 10)
	public String getConsumeUnit() {
		return this.consumeUnit;
	}

	public void setConsumeUnit(String consumeUnit) {
		this.consumeUnit = consumeUnit;
	}

	@Column(name = "services_desc", length = 50)
	public String getServicesDesc() {
		return this.servicesDesc;
	}

	public void setServicesDesc(String servicesDesc) {
		this.servicesDesc = servicesDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "merServices")
	public Set<CustCheckInConsume> getCustCheckInConsumes() {
		return this.custCheckInConsumes;
	}

	public void setCustCheckInConsumes(
			Set<CustCheckInConsume> custCheckInConsumes) {
		this.custCheckInConsumes = custCheckInConsumes;
	}

}