package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;


@Service
public interface LoanAmountsPgService {
	public void insertLoanAmountService(LoanAmountsPg newAmount);
	public LoanAmountsPg selectByloantypeidService(long loanAmountid) throws LoanAmountNotFoundException; 
	public List<LoanAmountsPg> selectByloantypeService(String loanType) throws LoanAmountNotFoundException;
	public List<LoanAmountsPg> selectByPriceService(int price) throws LoanAmountNotFoundException;
	public List<LoanAmountsPg> selectByMinimumSalaryReqService(int salary) throws LoanAmountNotFoundException;
	public void deleteLoanAmountService(long loanAmountId) throws LoanAmountNotFoundException;
	public List<LoanAmountsPg> selectAllLoanAmountsService();

}
