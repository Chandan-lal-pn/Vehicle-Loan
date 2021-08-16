package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the LOAN_PAYMENT_DET_PG database table.
 * 
 */
@Entity
@Table(name="LOAN_PAYMENT_DET_PG")
@NamedQuery(name="LoanPaymentDetPg.findAll", query="SELECT l FROM LoanPaymentDetPg l")
public class LoanPaymentDetPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_PAYMENT_ID")
	private long loanPaymentId;

	@Column(name="AMOUNT_DONE")
	private Integer amountDone;

	@Column(name="AMOUNT_LEFT")
	private Integer amountLeft;

	@Temporal(TemporalType.DATE)
	@Column(name="APPROVAL_DATE")
	private Date approvalDate;

	@Column(name="EMIS_FILLED")
	private Integer emisFilled;

	@Column(name="EMIS_LEFT")
	private Integer emisLeft;

	@Temporal(TemporalType.DATE)
	@Column(name="NEXT_DUE")
	private Date nextDue;

	//bi-directional many-to-one association to AdminDetail
	@ManyToOne
	@JoinColumn(name="BYADMIN_ID")
	private AdminDetail adminDetail;

	//bi-directional one-to-one association to ApplicationDetPg
	@OneToOne
	@JoinColumn(name="APPLICATION_ID")
	private ApplicationDetPg applicationDetPg;

	//bi-directional many-to-one association to EmiTransactionPg
	@OneToMany(mappedBy="loanPaymentDetPg", fetch=FetchType.EAGER)
	private List<EmiTransactionPg> emiTransactionPgs;

	public LoanPaymentDetPg() {
	}

	public Long getLoanPaymentId() {
		return this.loanPaymentId;
	}

	public void setLoanPaymentId(Long loanPaymentId) {
		this.loanPaymentId = loanPaymentId;
	}

	public Integer getAmountDone() {
		return this.amountDone;
	}

	public void setAmountDone(Integer amountDone) {
		this.amountDone = amountDone;
	}

	public Integer getAmountLeft() {
		return this.amountLeft;
	}

	public void setAmountLeft(Integer amountLeft) {
		this.amountLeft = amountLeft;
	}

	public Date getApprovalDate() {
		return this.approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Integer getEmisFilled() {
		return this.emisFilled;
	}

	public void setEmisFilled(Integer emisFilled) {
		this.emisFilled = emisFilled;
	}

	public Integer getEmisLeft() {
		return this.emisLeft;
	}

	public void setEmisLeft(Integer emisLeft) {
		this.emisLeft = emisLeft;
	}

	public Date getNextDue() {
		return this.nextDue;
	}

	public void setNextDue(Date nextDue) {
		this.nextDue = nextDue;
	}

	@JsonIgnore
	public AdminDetail getAdminDetail() {
		return this.adminDetail;
	}

	public void setAdminDetail(AdminDetail adminDetail) {
		this.adminDetail = adminDetail;
	}

	public ApplicationDetPg getApplicationDetPg() {
		return this.applicationDetPg;
	}

	public void setApplicationDetPg(ApplicationDetPg applicationDetPg) {
		this.applicationDetPg = applicationDetPg;
	}

	@JsonIgnore
	public List<EmiTransactionPg> getEmiTransactionPgs() {
		return this.emiTransactionPgs;
	}

	public void setEmiTransactionPgs(List<EmiTransactionPg> emiTransactionPgs) {
		this.emiTransactionPgs = emiTransactionPgs;
	}

	public EmiTransactionPg addEmiTransactionPg(EmiTransactionPg emiTransactionPg) {
		getEmiTransactionPgs().add(emiTransactionPg);
		emiTransactionPg.setLoanPaymentDetPg(this);

		return emiTransactionPg;
	}

	public EmiTransactionPg removeEmiTransactionPg(EmiTransactionPg emiTransactionPg) {
		getEmiTransactionPgs().remove(emiTransactionPg);
		emiTransactionPg.setLoanPaymentDetPg(null);

		return emiTransactionPg;
	}

}