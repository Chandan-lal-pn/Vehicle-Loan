package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LOAN_AMOUNTS_PG database table.
 * 
 */
@Entity
@Table(name="LOAN_AMOUNTS_PG")
@NamedQuery(name="LoanAmountsPg.findAll", query="SELECT l FROM LoanAmountsPg l")
public class LoanAmountsPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_TYPE_ID")
	private Long loanTypeId;

	@Column(name="INTEREST_RATE")
	private Integer interestRate;

	@Column(name="LOAN_TYPE")
	private String loanType;

	@Column(name="MAX_PRICE_RANGE")
	private Integer maxPriceRange;

	@Column(name="MIN_PRICE_RANGE")
	private Integer minPriceRange;

	@Column(name="MIN_SAL_REQ_PA")
	private Integer minSalReqPa;

	@Column(name="PROCESSING_FEE")
	private Integer processingFee;

	//bi-directional many-to-one association to ApplicationDetPg
//	@OneToMany(mappedBy="loanAmountsPg", fetch=FetchType.EAGER)
//	private List<ApplicationDetPg> applicationDetPgs;

	public LoanAmountsPg() {
	}

	public Long getLoanTypeId() {
		return this.loanTypeId;
	}

	public void setLoanTypeId(Long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public Integer getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}

	public String getLoanType() {
		return this.loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Integer getMaxPriceRange() {
		return this.maxPriceRange;
	}

	public void setMaxPriceRange(Integer maxPriceRange) {
		this.maxPriceRange = maxPriceRange;
	}

	public Integer getMinPriceRange() {
		return this.minPriceRange;
	}

	public void setMinPriceRange(Integer minPriceRange) {
		this.minPriceRange = minPriceRange;
	}

	public Integer getMinSalReqPa() {
		return this.minSalReqPa;
	}

	public void setMinSalReqPa(Integer minSalReqPa) {
		this.minSalReqPa = minSalReqPa;
	}

	public Integer getProcessingFee() {
		return this.processingFee;
	}

	public void setProcessingFee(Integer processingFee) {
		this.processingFee = processingFee;
	}

//	public List<ApplicationDetPg> getApplicationDetPgs() {
//		return this.applicationDetPgs;
//	}
//
//	public void setApplicationDetPgs(List<ApplicationDetPg> applicationDetPgs) {
//		this.applicationDetPgs = applicationDetPgs;
//	}

//	public ApplicationDetPg addApplicationDetPg(ApplicationDetPg applicationDetPg) {
//		getApplicationDetPgs().add(applicationDetPg);
//		applicationDetPg.setLoanAmountsPg(this);
//
//		return applicationDetPg;
//	}
//
//	public ApplicationDetPg removeApplicationDetPg(ApplicationDetPg applicationDetPg) {
//		getApplicationDetPgs().remove(applicationDetPg);
//		applicationDetPg.setLoanAmountsPg(null);
//
//		return applicationDetPg;
//	}

}