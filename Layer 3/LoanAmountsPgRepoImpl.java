package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;


@Repository
public class LoanAmountsPgRepoImpl extends BaseRepository implements LoanAmountsPgRepo {

	
	public LoanAmountsPgRepoImpl() {
		super();
		System.out.println("Inside LoanAmountsPgRepoIMPL layer");
	}

	@Transactional
	public void insertLoanAmount(LoanAmountsPg newAmount) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(newAmount); //based on PK
		System.out.println("newAmount inserted..."+newAmount);
	}

	@Transactional
	public LoanAmountsPg selectByloantypeid(long loanAmountid) throws LoanAmountNotFoundException {
		EntityManager entityManager = getEntityManager();
		System.out.println("Repo Impl-Select By loanAmountid");
		return entityManager.find(LoanAmountsPg.class,loanAmountid);
		
	}

	@Transactional
	public List<LoanAmountsPg> selectByloantype(String loanType) throws LoanAmountNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from LoanAmountsPg e where e.loanType = :loanType");
		query.setParameter("loanType", loanType);
		List<LoanAmountsPg> byloantype = query.getResultList();
		System.out.println("Repo Impl-Select By Loan Type");
		return byloantype;
		
	}

	@Transactional
	public List<LoanAmountsPg> selectByPrice(int price) throws LoanAmountNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from LoanAmountsPg e where e.minPriceRange < :price and e.maxPriceRange > :price");
		query.setParameter("price", price);
		List<LoanAmountsPg> byPrice = query.getResultList();
		System.out.println("Repo Impl-Select By Min Max Price");
		return byPrice;
	}

	@Transactional
	public List<LoanAmountsPg> selectByMinimumSalaryReq(int salary) throws LoanAmountNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from LoanAmountsPg e where e.minSalReqPa > :salary");
		query.setParameter("salary", salary);
		List<LoanAmountsPg> byMinimumSalaryReq = query.getResultList();
		System.out.println("Repo Impl-Select By Minimum SalaryReq");
		return byMinimumSalaryReq;
	}

	@Transactional
	public void deleteLoanAmount(long loanAmountId) throws LoanAmountNotFoundException {
		EntityManager entityManager = getEntityManager();
		LoanAmountsPg foundloanAmount = entityManager.find(LoanAmountsPg.class, loanAmountId); //find it 
		if(foundloanAmount!=null) {
			entityManager.remove(foundloanAmount); 
		}	
		else {
			throw new LoanAmountNotFoundException("LoanAmount Not Found with loanAmountId : "+loanAmountId);
		}
		System.out.println("EntityManager: employee removed.. ");

	}

	@Transactional
	public List<LoanAmountsPg> selectAllLoanAmounts() {
		System.out.println("Layer3 : loanAmountPgRepoImpl");
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" from LoanAmountsPg");
		List<LoanAmountsPg> loanAmtList = query.getResultList();
		System.out.println("loanAmtList" + loanAmtList.size());
		
		return loanAmtList;
	}

}
