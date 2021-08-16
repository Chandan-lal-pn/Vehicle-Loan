package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUST_IDENTITY_DETAILS_PG database table.
 * 
 */
@Entity
@Table(name="CUST_IDENTITY_DETAILS_PG")
@NamedQuery(name="CustIdentityDetailsPg.findAll", query="SELECT c FROM CustIdentityDetailsPg c")
public class CustIdentityDetailsPg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_IDENTITY_ID")
	private Long custIdentityId;

	@Column(name="IDENTITY_ID")
	private String identityId;

	@Column(name="IDENTITY_TYPE")
	private String identityType;

	//bi-directional many-to-one association to CustBasicDetailsPg
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private CustBasicDetailsPg custBasicDetailsPg;

	public CustIdentityDetailsPg() {
	}

	public Long getCustIdentityId() {
		return this.custIdentityId;
	}

	public void setCustIdentityId(Long custIdentityId) {
		this.custIdentityId = custIdentityId;
	}

	public String getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public CustBasicDetailsPg getCustBasicDetailsPg() {
		return this.custBasicDetailsPg;
	}

	public void setCustBasicDetailsPg(CustBasicDetailsPg custBasicDetailsPg) {
		this.custBasicDetailsPg = custBasicDetailsPg;
	}

}