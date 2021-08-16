package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;
import com.example.demo.layer3.exceptions.LoanPaymentNotFoundException;

@Repository
public class LoanPaymentDetPgRepoImpl extends BaseRepository implements LoanPaymentDetPgRepo {

	@Transactional
	@Override
	public void newLoan(LoanPaymentDetPg newLoan) {
		// TODO Auto-generated method stub
		System.out.println("loan pay repo new loan");
		getEntityManager().persist(newLoan);
	}

	@Transactional
	@Override
	public void updateAfterEmi(LoanPaymentDetPg updateLoan) {
		// TODO Auto-generated method stub
		System.out.println("loan pay repo update loan");
		getEntityManager().merge(updateLoan);
	}

	@Transactional
	@Override
	public List<LoanPaymentDetPg> getAllLoanPayments() throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loan pay repo getall");
		List<LoanPaymentDetPg> tempList= getEntityManager().createQuery(" from LoanPaymentDetPg").getResultList();
		return tempList;
	}

	@Transactional
	@Override
	public List<LoanPaymentDetPg> getLoanPaymentByMobile(String mobile) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<LoanPaymentDetPg> getLoanPaymentByEmail(String email) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public LoanPaymentDetPg getLoanPaymentByApplicationId(long appId) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loan pay repo get by appid");
		LoanPaymentDetPg loan=(LoanPaymentDetPg) getEntityManager().createQuery("select a.loanPaymentDetPg from ApplicationDetPg a where a.applicationId =: appId").setParameter("appId", appId).getSingleResult();
		if(loan == null) throw new LoanPaymentNotFoundException("application not found");
		return loan;
	}

	@Override
	public List<LoanPaymentDetPg> getLoanPaymentByCustId(long custId) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loan pay repo get by custid");
		CustBasicDetailsPg cust= getEntityManager().find(CustBasicDetailsPg.class, custId);
		System.out.println("cust found");
		List<LoanPaymentDetPg> loans= getEntityManager().createQuery("select a.loanPaymentDetPg from ApplicationDetPg a where a.custBasicDetailsPg =: cust").setParameter("cust", cust).getResultList();
		if(loans.size()>0) System.out.println("loans found"+loans);
		return loans;
	}

}
