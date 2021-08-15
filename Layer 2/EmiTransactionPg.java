package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the EMI_TRANSACTION_PG database table.
 * 
 */
@Entity
@Table(name="EMI_TRANSACTION_PG")
@NamedQuery(name="EmiTransactionPg.findAll", query="SELECT e FROM EmiTransactionPg e")
public class EmiTransactionPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMI_ID")
	private long emiId;

	@Column(name="EMI_NUMBER")
	private Integer emiNumber;

	@Column(name="TRANSACTION_AMOUNT")
	private Integer transactionAmount;

	@Column(name="TRANSACTION_DATETIME")
	private Timestamp transactionDatetime;

	//bi-directional many-to-one association to LoanPaymentDetPg
	@ManyToOne
	@JoinColumn(name="LOAN_PAYMENT_ID")
	private LoanPaymentDetPg loanPaymentDetPg;

	public EmiTransactionPg() {
	}

	public long getEmiId() {
		return this.emiId;
	}

	public void setEmiId(long emiId) {
		this.emiId = emiId;
	}

	public Integer getEmiNumber() {
		return this.emiNumber;
	}

	public void setEmiNumber(Integer emiNumber) {
		this.emiNumber = emiNumber;
	}

	public Integer getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDatetime() {
		return this.transactionDatetime;
	}

	public void setTransactionDatetime(Timestamp transactionDatetime) {
		this.transactionDatetime = transactionDatetime;
	}

	public LoanPaymentDetPg getLoanPaymentDetPg() {
		return this.loanPaymentDetPg;
	}

	public void setLoanPaymentDetPg(LoanPaymentDetPg loanPaymentDetPg) {
		this.loanPaymentDetPg = loanPaymentDetPg;
	}

}