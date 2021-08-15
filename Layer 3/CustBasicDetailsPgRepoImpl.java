package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;

@Repository
public class CustBasicDetailsPgRepoImpl extends BaseRepository implements CustBasicDetailsRepo {

	@Transactional
	@Override
	public void registerCustomer(CustBasicDetailsPg registerCust) {
		// TODO Auto-generated method stub
		getEntityManager().persist(registerCust);
		System.out.println("impl cust registered");
	}


	@Transactional
	@Override
	public void insertCustomerObject(CustBasicDetailsPg insertCust) {
		// TODO Auto-generated method stub
		getEntityManager().persist(insertCust);
		System.out.println("impl cust object added");
	}

	@Transactional
	@Override
	public List<CustBasicDetailsPg> selectAllCustomer() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Customer repository selectAllCust() invoked");
		return getEntityManager().createQuery(" from CustBasicDetailsPg").getResultList();
	}

	@Transactional
	@Override
	public CustBasicDetailsPg selectCustomerById(Long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return getEntityManager().find(CustBasicDetailsPg.class,id);
	}

	@Transactional
	@Override
	public CustBasicDetailsPg selectCustomerByMobile(String mobile) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return (CustBasicDetailsPg) getEntityManager().createQuery("select c from CustBasicDetailsPg c where mobile=: mob").setParameter("mob", mobile).getSingleResult();
	}

	@Transactional
	@Override
	public CustBasicDetailsPg selectCustomerByEmail(String emailId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return (CustBasicDetailsPg) getEntityManager().createQuery("select c from CustBasicDetailsPg c where emailId=: email").setParameter("email", emailId).getSingleResult();
	}

	@Transactional
	@Override
	public List<CustBasicDetailsPg> selectCustomerByNationality(String nationality) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<CustBasicDetailsPg> selectCustomerByNetSalary(Integer salary) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CustBasicDetailsPg loginCustomer(CustBasicDetailsPg verifyCust) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return (CustBasicDetailsPg) 
				getEntityManager().createQuery("select c from CustBasicDetailsPg c where c.mobile =: mob and c.loginPassword =: pass")
				.setParameter("mob",verifyCust.getMobile()).setParameter("pass", verifyCust.getLoginPassword()).getSingleResult();
	}

	

}
