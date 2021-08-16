package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer3.LoanAmountsPgRepoImpl;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;


@Service
public class LoanAmountsPgServiceImpl implements LoanAmountsPgService {

	@Autowired
	LoanAmountsPgRepoImpl loanRepo;

	@Override
	public void insertLoanAmountService(LoanAmountsPg newAmount) {
		loanRepo.insertLoanAmount(newAmount);
		System.out.println("Record Inserted"); 
	}

	@Override
	public LoanAmountsPg selectByloantypeidService(long loanAmountid) throws LoanAmountNotFoundException {
		return loanRepo.selectByloantypeid(loanAmountid);
	}

	@Override
	public List<LoanAmountsPg> selectByloantypeService(String loanType) throws LoanAmountNotFoundException {
		
		return loanRepo.selectByloantype(loanType);
	}

	@Override
	public List<LoanAmountsPg> selectByPriceService(int price)throws LoanAmountNotFoundException {
		return loanRepo.selectByPrice(price);
	}

	@Override
	public List<LoanAmountsPg> selectByMinimumSalaryReqService(int salary) throws LoanAmountNotFoundException {
		// TODO Auto-generated method stub
		return loanRepo.selectByMinimumSalaryReq(salary);
	}

	@Override
	public void deleteLoanAmountService(long loanAmountId) {
		System.out.println("deleteLoanAmountService() ..method");
		String message = "LoanAmount Not Found";
		boolean deleted = false;
		try {
			loanRepo.deleteLoanAmount(loanAmountId);
			deleted = true;
			message = "LoanAmount Deleted";
			System.out.println("Service Deleted");
		} catch (LoanAmountNotFoundException msg) {
			msg.printStackTrace();
		}
	}

	@Override
	public List<LoanAmountsPg> selectAllLoanAmountsService() {
		System.out.println("selectAllLoanAmountsService layer4");
		return loanRepo.selectAllLoanAmounts();
	}

}
