package com.dewey.his.common.model;

import static javax.persistence.GenerationType.IDENTITY;
import hibernate.Customer;
import hibernate.Relief;
import hibernate.ReserveApplication;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.dewey.his.crm.model.ContractualUnit;
import com.dewey.his.param.model.ChargeRuleSetting;
import com.dewey.his.param.model.HotelInfoSetting;
import com.dewey.his.param.model.RoomType;
import com.dewey.his.reception.model.CheckIn;
import com.dewey.his.reservation.model.Reservation;
import com.dewey.his.sys.model.MerRole;
import com.dewey.his.sys.model.MerRoom;
import com.dewey.his.sys.model.MerUser;

/**
 * Mer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mer", uniqueConstraints = @UniqueConstraint(columnNames = "dewey_no"))
public class Mer implements java.io.Serializable {

	// Fields

	private Long id;
	private String deweyNo;
	private String merNo;
	private String shortName;
	private String fullName;
	private String companyName;
	private Long roomNum;
	private String fax;
	private String telephone;
	private String mobilephone;
	private String address;
	private String postcode;
	private String email;
	private String remark;
	private String juridicalPerson;
	private String juridicalPersonIdCopy;
	private String licenseCopy;
	private String applyFunctions;
	private String administrator;
	private String password;
	private String webUrl;
	private String linkmanName;
	private String linkmanSex;
	private String linkmanPhone;
	private String status;


	private Timestamp lcd;
	private Set<HotelInfoSetting> hotelInfoSettings = new HashSet<HotelInfoSetting>(0);
	private Set<MerRoom> merRooms = new HashSet<MerRoom>(0);
	private Set<CheckIn> checkIns = new HashSet<CheckIn>(0);
	private Set<ChargeRuleSetting> chargeRuleSettings = new HashSet<ChargeRuleSetting>(	0);
	private Set<Reservation> reservations = new HashSet<Reservation>(0);
	private Set<MerRole> merRoles = new HashSet<MerRole>(0);
	private Set<RoomType> roomTypes = new HashSet<RoomType>(0);
	private Set<Customer> customers = new HashSet<Customer>(0);
	private Set<ContractualUnit> contractualUnits = new HashSet<ContractualUnit>(0);
	private Set<ReserveApplication> reserveApplications = new HashSet<ReserveApplication>(0);
	private Set<Relief> reliefs = new HashSet<Relief>(0);
	private Set<MerUser> merUsers = new HashSet<MerUser>(0);

	// Constructors

	/** default constructor */
	public Mer() {
	}

	/** minimal constructor */
	public Mer(String deweyNo) {
		this.deweyNo = deweyNo;
	}

	/** full constructor */
	public Mer(String deweyNo, String merNo, String shortName, String fullName,
			String companyName, Long roomNum, String fax, String telephone,
			String mobilephone, String address, String postcode, String email,
			String remark, String juridicalPerson,
			String juridicalPersonIdCopy, String licenseCopy,
			String applyFunctions, String administrator, String password,
			String webUrl, String linkmanName, String linkmanSex,
			String linkmanPhone, Timestamp lcd,
			Set<HotelInfoSetting> hotelInfoSettings, Set<MerRoom> merRooms,
			Set<CheckIn> checkIns, Set<ChargeRuleSetting> chargeRuleSettings,
			Set<Reservation> reservations, Set<MerRole> merRoles,
			Set<RoomType> roomTypes, Set<Customer> customers,
			Set<ContractualUnit> contractualUnits,
			Set<ReserveApplication> reserveApplications, Set<Relief> reliefs,
			Set<MerUser> merUsers,String status) {
		this.deweyNo = deweyNo;
		this.merNo = merNo;
		this.shortName = shortName;
		this.fullName = fullName;
		this.companyName = companyName;
		this.roomNum = roomNum;
		this.fax = fax;
		this.telephone = telephone;
		this.mobilephone = mobilephone;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
		this.remark = remark;
		this.juridicalPerson = juridicalPerson;
		this.juridicalPersonIdCopy = juridicalPersonIdCopy;
		this.licenseCopy = licenseCopy;
		this.applyFunctions = applyFunctions;
		this.administrator = administrator;
		this.password = password;
		this.webUrl = webUrl;
		this.linkmanName = linkmanName;
		this.linkmanSex = linkmanSex;
		this.linkmanPhone = linkmanPhone;
		this.lcd = lcd;
		this.hotelInfoSettings = hotelInfoSettings;
		this.merRooms = merRooms;
		this.checkIns = checkIns;
		this.chargeRuleSettings = chargeRuleSettings;
		this.reservations = reservations;
		this.merRoles = merRoles;
		this.roomTypes = roomTypes;
		this.customers = customers;
		this.contractualUnits = contractualUnits;
		this.reserveApplications = reserveApplications;
		this.reliefs = reliefs;
		this.merUsers = merUsers;
		this.status=status;
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

	@Column(name = "dewey_no", unique = true, nullable = false, length = 15)
	public String getDeweyNo() {
		return this.deweyNo;
	}

	public void setDeweyNo(String deweyNo) {
		this.deweyNo = deweyNo;
	}

	@Column(name = "mer_no", length = 15)
	public String getMerNo() {
		return this.merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	@Column(name = "short_name", length = 20)
	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Column(name = "full_name", length = 50)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "company_name", length = 120)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "room_num", precision = 10, scale = 0)
	public Long getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(Long roomNum) {
		this.roomNum = roomNum;
	}

	@Column(name = "fax", length = 20)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "telephone", length = 8)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "mobilephone", length = 13)
	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Column(name = "address", length = 8)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "postcode", length = 6)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "email", length = 8)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "remark", length = 8)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "juridical_person", length = 8)
	public String getJuridicalPerson() {
		return this.juridicalPerson;
	}

	public void setJuridicalPerson(String juridicalPerson) {
		this.juridicalPerson = juridicalPerson;
	}

	@Column(name = "juridical_person_id_copy", length = 8)
	public String getJuridicalPersonIdCopy() {
		return this.juridicalPersonIdCopy;
	}

	public void setJuridicalPersonIdCopy(String juridicalPersonIdCopy) {
		this.juridicalPersonIdCopy = juridicalPersonIdCopy;
	}

	@Column(name = "license_copy", length = 8)
	public String getLicenseCopy() {
		return this.licenseCopy;
	}

	public void setLicenseCopy(String licenseCopy) {
		this.licenseCopy = licenseCopy;
	}

	@Column(name = "apply_functions", length = 8)
	public String getApplyFunctions() {
		return this.applyFunctions;
	}

	public void setApplyFunctions(String applyFunctions) {
		this.applyFunctions = applyFunctions;
	}

	@Column(name = "administrator", length = 8)
	public String getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	@Column(name = "password", length = 8)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "web_url", length = 50)
	public String getWebUrl() {
		return this.webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	@Column(name = "linkman_name", length = 50)
	public String getLinkmanName() {
		return this.linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	@Column(name = "linkman_sex", length = 2)
	public String getLinkmanSex() {
		return this.linkmanSex;
	}

	public void setLinkmanSex(String linkmanSex) {
		this.linkmanSex = linkmanSex;
	}

	@Column(name = "linkman_phone", length = 50)
	public String getLinkmanPhone() {
		return this.linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	@Column(name = "lcd", length = 23)
	public Timestamp getLcd() {
		return this.lcd;
	}

	public void setLcd(Timestamp lcd) {
		this.lcd = lcd;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<HotelInfoSetting> getHotelInfoSettings() {
		return this.hotelInfoSettings;
	}

	public void setHotelInfoSettings(Set<HotelInfoSetting> hotelInfoSettings) {
		this.hotelInfoSettings = hotelInfoSettings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<MerRoom> getMerRooms() {
		return this.merRooms;
	}

	public void setMerRooms(Set<MerRoom> merRooms) {
		this.merRooms = merRooms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<CheckIn> getCheckIns() {
		return this.checkIns;
	}

	public void setCheckIns(Set<CheckIn> checkIns) {
		this.checkIns = checkIns;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<ChargeRuleSetting> getChargeRuleSettings() {
		return this.chargeRuleSettings;
	}

	public void setChargeRuleSettings(Set<ChargeRuleSetting> chargeRuleSettings) {
		this.chargeRuleSettings = chargeRuleSettings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<MerRole> getMerRoles() {
		return this.merRoles;
	}

	public void setMerRoles(Set<MerRole> merRoles) {
		this.merRoles = merRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<RoomType> getRoomTypes() {
		return this.roomTypes;
	}

	public void setRoomTypes(Set<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<ContractualUnit> getContractualUnits() {
		return this.contractualUnits;
	}

	public void setContractualUnits(Set<ContractualUnit> contractualUnits) {
		this.contractualUnits = contractualUnits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<ReserveApplication> getReserveApplications() {
		return this.reserveApplications;
	}

	public void setReserveApplications(
			Set<ReserveApplication> reserveApplications) {
		this.reserveApplications = reserveApplications;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<Relief> getReliefs() {
		return this.reliefs;
	}

	public void setReliefs(Set<Relief> reliefs) {
		this.reliefs = reliefs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mer")
	public Set<MerUser> getMerUsers() {
		return this.merUsers;
	}

	public void setMerUsers(Set<MerUser> merUsers) {
		this.merUsers = merUsers;
	}
	@Column(name = "status", length = 1)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}