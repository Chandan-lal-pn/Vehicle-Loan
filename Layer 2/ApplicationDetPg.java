package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the APPLICATION_DET_PG database table.
 * 
 */
@Entity
@Table(name="APPLICATION_DET_PG")
@NamedQuery(name="ApplicationDetPg.findAll", query="SELECT a FROM ApplicationDetPg a")
public class ApplicationDetPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPLICATION_ID")
	private long applicationId;

	@Column(name="APPLICATION_STATUS")
	private String applicationStatus;

	private String description;

	@Column(name="EMI_AMOUNT")
	private Integer emiAmount;

	@Column(name="LOAN_AMOUNT")
	private Integer loanAmount;

	@Column(name="LOAN_TENURE_MON")
	private Integer loanTenureMon;

	@Column(name="NO_OF_EMIS")
	private Integer noOfEmis;

	@Column(name="VEHICLE_CHASSIS_NO")
	private String vehicleChassisNo;

	@Column(name="WITNESS_NAME")
	private String witnessName;

	//bi-directional many-to-one association to CustBasicDetailsPg
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private CustBasicDetailsPg custBasicDetailsPg;

	//bi-directional many-to-one association to LoanAmountsPg
	@ManyToOne
	@JoinColumn(name="LOAN_TYPE_ID")
	private LoanAmountsPg loanAmountsPg;

	//bi-directional many-to-one association to VehicleModelPg
	@ManyToOne
	@JoinColumn(name="MODEL_ID")
	private VehicleModelPg vehicleModelPg;

	//bi-directional one-to-one association to LoanPaymentDetPg
	@OneToOne(mappedBy="applicationDetPg")
	private LoanPaymentDetPg loanPaymentDetPg;

	public ApplicationDetPg() {
	}

	public long getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationStatus() {
		return this.applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getEmiAmount() {
		return this.emiAmount;
	}

	public void setEmiAmount(Integer emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Integer getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanTenureMon() {
		return this.loanTenureMon;
	}

	public void setLoanTenureMon(Integer loanTenureMon) {
		this.loanTenureMon = loanTenureMon;
	}

	public Integer getNoOfEmis() {
		return this.noOfEmis;
	}

	public void setNoOfEmis(Integer noOfEmis) {
		this.noOfEmis = noOfEmis;
	}

	public String getVehicleChassisNo() {
		return this.vehicleChassisNo;
	}

	public void setVehicleChassisNo(String vehicleChassisNo) {
		this.vehicleChassisNo = vehicleChassisNo;
	}

	public String getWitnessName() {
		return this.witnessName;
	}

	public void setWitnessName(String witnessName) {
		this.witnessName = witnessName;
	}

	public CustBasicDetailsPg getCustBasicDetailsPg() {
		return this.custBasicDetailsPg;
	}

	public void setCustBasicDetailsPg(CustBasicDetailsPg custBasicDetailsPg) {
		this.custBasicDetailsPg = custBasicDetailsPg;
	}

	public LoanAmountsPg getLoanAmountsPg() {
		return this.loanAmountsPg;
	}

	public void setLoanAmountsPg(LoanAmountsPg loanAmountsPg) {
		this.loanAmountsPg = loanAmountsPg;
	}

	public VehicleModelPg getVehicleModelPg() {
		return this.vehicleModelPg;
	}

	public void setVehicleModelPg(VehicleModelPg vehicleModelPg) {
		this.vehicleModelPg = vehicleModelPg;
	}
	
	@JsonIgnore
	public LoanPaymentDetPg getLoanPaymentDetPg() {
		return this.loanPaymentDetPg;
	}

	public void setLoanPaymentDetPg(LoanPaymentDetPg loanPaymentDetPg) {
		this.loanPaymentDetPg = loanPaymentDetPg;
	}

}