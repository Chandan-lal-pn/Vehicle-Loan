package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the ADMIN_DETAILS database table.
 * 
 */
@Entity
@Table(name="ADMIN_DETAILS")
@NamedQuery(name="AdminDetail.findAll", query="SELECT a FROM AdminDetail a")
public class AdminDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADMIN_ID")
	private long adminId;

	@Column(name="ADMIN_PASSWORD")
	private String adminPassword;

	@Column(name="ADMIN_USERID")
	private String adminUserid;

	@Column(name="ADMIN_USERNAME")
	private String adminUsername;

	//bi-directional many-to-one association to LoanPaymentDetPg
	@OneToMany(mappedBy="adminDetail", fetch=FetchType.EAGER)
	private List<LoanPaymentDetPg> loanPaymentDetPgs;

	public AdminDetail() {
	}

	public long getAdminId() {
		return this.adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminUserid() {
		return this.adminUserid;
	}

	public void setAdminUserid(String adminUserid) {
		this.adminUserid = adminUserid;
	}

	public String getAdminUsername() {
		return this.adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	@JsonIgnore
	public List<LoanPaymentDetPg> getLoanPaymentDetPgs() {
		return this.loanPaymentDetPgs;
	}

	public void setLoanPaymentDetPgs(List<LoanPaymentDetPg> loanPaymentDetPgs) {
		this.loanPaymentDetPgs = loanPaymentDetPgs;
	}

	public LoanPaymentDetPg addLoanPaymentDetPg(LoanPaymentDetPg loanPaymentDetPg) {
		getLoanPaymentDetPgs().add(loanPaymentDetPg);
		loanPaymentDetPg.setAdminDetail(this);

		return loanPaymentDetPg;
	}

	public LoanPaymentDetPg removeLoanPaymentDetPg(LoanPaymentDetPg loanPaymentDetPg) {
		getLoanPaymentDetPgs().remove(loanPaymentDetPg);
		loanPaymentDetPg.setAdminDetail(null);

		return loanPaymentDetPg;
	}

}