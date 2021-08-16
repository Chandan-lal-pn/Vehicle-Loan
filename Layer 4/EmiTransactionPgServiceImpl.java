package com.example.demo.layer4;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer3.EmiTransactionPgRepoImpl;
import com.example.demo.layer3.exceptions.EmiTransactionNotFoundException;

@Service
public class EmiTransactionPgServiceImpl implements EmiTransactionPgService{

	@Autowired
	EmiTransactionPgRepoImpl emitRepo;
	@Override
	public void insertEmiService(EmiTransactionPg insertEmi, long loanId) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
//		return emitRepo.insertEmi(insertEmi, loanId);
		System.out.println("Insert EMI Service Implementation");
	}

	@Override
	public List<EmiTransactionPg> getAllEmisService() throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		return emitRepo.getAllEmis();
	}

	@Override
	public List<EmiTransactionPg> selectEmiByLoanPaymentIdService(long id) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		return emitRepo.selectEmiByLoanPaymentId(id);
	}

	@Override
	public EmiTransactionPg selectEmibyIdService(long emiId) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		return emitRepo.selectEmibyId(emiId);
	}

	@Override
	public List<EmiTransactionPg> selectEmiByDateService(Date datefrom, Date datetill)
			throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		return emitRepo.selectEmiByDate(datefrom, datetill);
	}
	

}
