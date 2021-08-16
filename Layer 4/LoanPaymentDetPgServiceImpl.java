package com.example.demo.layer4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.LoanPaymentDetPgRepoImpl;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;
import com.example.demo.layer3.exceptions.LoanPaymentNotFoundException;

@Service
public class LoanPaymentDetPgServiceImpl extends BaseRepository implements LoanPaymentDetPgService {

	@Autowired
	LoanPaymentDetPgRepoImpl loanRepo;
	
	@Override
	public void newLoanService(long appId, long adminId) {
		// TODO Auto-generated method stub
		System.out.println("loan pay service newLoan");
		ApplicationDetPg application = getEntityManager().find(ApplicationDetPg.class, appId);
		AdminDetail admin = getEntityManager().find(AdminDetail.class, adminId);
		LoanPaymentDetPg temp = new LoanPaymentDetPg();
		temp.setApplicationDetPg(application);
		temp.setAdminDetail(admin);
		try {
			temp.setApprovalDate(new SimpleDateFormat("dd-MM-yyyy").parse(LocalDate.now().toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp.setEmisFilled(0);
		temp.setEmisLeft(application.getNoOfEmis());
		temp.setAmountDone(0);
		temp.setAmountLeft(application.getLoanAmount());
		try {
			temp.setNextDue(new SimpleDateFormat("dd-MM-yyyy").parse(LocalDate.now().plusMonths(1).toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		loanRepo.newLoan(temp);
	}

	@Override
	public void updateAfterEmiService(long loanId, long emiId) {
		// TODO Auto-generated method stub	
		LoanPaymentDetPg temp= getEntityManager().find(LoanPaymentDetPg.class, loanId);
		EmiTransactionPg emi= getEntityManager().find(EmiTransactionPg.class, emiId);
		LoanPaymentDetPg verify = emi.getLoanPaymentDetPg();
		if(temp!=verify) return;
		temp.setEmisFilled(temp.getEmisFilled()+1);
		temp.setEmisLeft(temp.getEmisLeft()-1);
		temp.setAmountDone(temp.getAmountDone()+ emi.getTransactionAmount());
		temp.setAmountLeft(temp.getAmountLeft()- emi.getTransactionAmount());
//		try {
//			temp.setNextDue(new SimpleDateFormat("dd-MM-yyyy").parse(temp.getNextDue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(1).toString()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		loanRepo.updateAfterEmi(temp);
	}

	@Override
	public List<LoanPaymentDetPg> getAllLoanPaymentsService() throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return loanRepo.getAllLoanPayments();
	}

	@Override
	public List<LoanPaymentDetPg> getLoanPaymentByMobileService(String mobile) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanPaymentDetPg> getLoanPaymentByEmailService(String email) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanPaymentDetPg getLoanPaymentByApplicationIdService(long appId) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return loanRepo.getLoanPaymentByApplicationId(appId);
	}

	@Override
	public List<LoanPaymentDetPg> getLoanPaymentByCustIdService(long custId) throws LoanPaymentNotFoundException {
		// TODO Auto-generated method stub
		return loanRepo.getLoanPaymentByCustId(custId);
	}

}
