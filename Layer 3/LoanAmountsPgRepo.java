package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;


@Repository
public interface LoanAmountsPgRepo {
	public void insertLoanAmount(LoanAmountsPg newAmount);
	public LoanAmountsPg selectByloantypeid(long loanAmountid) throws LoanAmountNotFoundException; 
	public List<LoanAmountsPg> selectByloantype(String loanType) throws LoanAmountNotFoundException;
	public List<LoanAmountsPg> selectByPrice(int price) throws LoanAmountNotFoundException;
	public List<LoanAmountsPg> selectByMinimumSalaryReq(int salary) throws LoanAmountNotFoundException;
	public void deleteLoanAmount(long loanAmountId) throws LoanAmountNotFoundException;
	public List<LoanAmountsPg> selectAllLoanAmounts();
}
