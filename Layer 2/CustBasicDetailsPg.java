package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CUST_BASIC_DETAILS_PG database table.
 * 
 */
@Entity
@Table(name="CUST_BASIC_DETAILS_PG")
@NamedQuery(name="CustBasicDetailsPg.findAll", query="SELECT c FROM CustBasicDetailsPg c")
public class CustBasicDetailsPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID")
	private Long custId;

	private Integer age;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="EMPLOYER_NAME")
	private String employerName;

	@Column(name="EXISTING_EMIS_AMOUNT")
	private Integer existingEmisAmount;

	@Column(name="EXISTING_EMIS_COUNT")
	private Integer existingEmisCount;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="LOGIN_PASSWORD")
	private String loginPassword;

	private String mobile;

	private String nationality;

	@Column(name="PIN_CODE")
	private String pinCode;

	@Column(name="RESIDENCE_ADDRESS")
	private String residenceAddress;

	@Column(name="RESIDENCE_CITY")
	private String residenceCity;

	@Column(name="RESIDENCE_STATE")
	private String residenceState;

	@Column(name="SALARY_PA")
	private Integer salaryPa;

	@Column(name="TYPE_OF_EMPLOYMENT")
	private String typeOfEmployment;

//	//bi-directional many-to-one association to ApplicationDetPg
	@OneToMany(mappedBy="custBasicDetailsPg", fetch=FetchType.EAGER)
	private List<ApplicationDetPg> applicationDetPgs;

	//bi-directional many-to-one association to CustIdentityDetailsPg
//	@OneToMany(mappedBy="custBasicDetailsPg", fetch=FetchType.EAGER)
//	private List<CustIdentityDetailsPg> custIdentityDetailsPgs;

	public CustBasicDetailsPg() {
	}

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmployerName() {
		return this.employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public Integer getExistingEmisAmount() {
		return this.existingEmisAmount;
	}

	public void setExistingEmisAmount(Integer existingEmisAmount) {
		this.existingEmisAmount = existingEmisAmount;
	}

	public Integer getExistingEmisCount() {
		return this.existingEmisCount;
	}

	public void setExistingEmisCount(Integer existingEmisCount) {
		this.existingEmisCount = existingEmisCount;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getResidenceAddress() {
		return this.residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getResidenceCity() {
		return this.residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getResidenceState() {
		return this.residenceState;
	}

	public void setResidenceState(String residenceState) {
		this.residenceState = residenceState;
	}

	public Integer getSalaryPa() {
		return this.salaryPa;
	}

	public void setSalaryPa(Integer salaryPa) {
		this.salaryPa = salaryPa;
	}

	public String getTypeOfEmployment() {
		return this.typeOfEmployment;
	}

	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}

	@JsonIgnore
	public List<ApplicationDetPg> getApplicationDetPgs() {
		return this.applicationDetPgs;
	}

	public void setApplicationDetPgs(List<ApplicationDetPg> applicationDetPgs) {
		this.applicationDetPgs = applicationDetPgs;
	}

	public ApplicationDetPg addApplicationDetPg(ApplicationDetPg applicationDetPg) {
		getApplicationDetPgs().add(applicationDetPg);
		applicationDetPg.setCustBasicDetailsPg(this);

		return applicationDetPg;
	}

	public ApplicationDetPg removeApplicationDetPg(ApplicationDetPg applicationDetPg) {
		getApplicationDetPgs().remove(applicationDetPg);
		applicationDetPg.setCustBasicDetailsPg(null);

		return applicationDetPg;
	}

//	public List<CustIdentityDetailsPg> getCustIdentityDetailsPgs() {
//		return this.custIdentityDetailsPgs;
//	}
//
//	public void setCustIdentityDetailsPgs(List<CustIdentityDetailsPg> custIdentityDetailsPgs) {
//		this.custIdentityDetailsPgs = custIdentityDetailsPgs;
//	}
//
//	public CustIdentityDetailsPg addCustIdentityDetailsPg(CustIdentityDetailsPg custIdentityDetailsPg) {
//		getCustIdentityDetailsPgs().add(custIdentityDetailsPg);
//		custIdentityDetailsPg.setCustBasicDetailsPg(this);
//
//		return custIdentityDetailsPg;
//	}
//
//	public CustIdentityDetailsPg removeCustIdentityDetailsPg(CustIdentityDetailsPg custIdentityDetailsPg) {
//		getCustIdentityDetailsPgs().remove(custIdentityDetailsPg);
//		custIdentityDetailsPg.setCustBasicDetailsPg(null);
//
//		return custIdentityDetailsPg;
//	}

}