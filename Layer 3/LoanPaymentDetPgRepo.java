package com.example.demo.layer3;

import java.util.List;

import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer3.exceptions.LoanPaymentNotFoundException;

public interface LoanPaymentDetPgRepo {
	
	void newLoan(LoanPaymentDetPg newLoan);
	void updateAfterEmi(LoanPaymentDetPg updateLoan);
	List<LoanPaymentDetPg> getAllLoanPayments() throws LoanPaymentNotFoundException;
	List<LoanPaymentDetPg> getLoanPaymentByMobile(String mobile) throws LoanPaymentNotFoundException;
	List<LoanPaymentDetPg> getLoanPaymentByEmail(String email) throws LoanPaymentNotFoundException;
	LoanPaymentDetPg getLoanPaymentByApplicationId(long appId) throws LoanPaymentNotFoundException;
	List<LoanPaymentDetPg> getLoanPaymentByCustId(long custId) throws LoanPaymentNotFoundException;

}
