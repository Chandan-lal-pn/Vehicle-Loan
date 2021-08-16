package com.example.demo.layer4;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer3.exceptions.EmiTransactionNotFoundException;

@Service
public interface EmiTransactionPgService {
	
	void insertEmiService(EmiTransactionPg insertEmi,long loanId) throws EmiTransactionNotFoundException;
	List <EmiTransactionPg> getAllEmisService() throws EmiTransactionNotFoundException;
	List<EmiTransactionPg> selectEmiByLoanPaymentIdService(long id) throws EmiTransactionNotFoundException;
	EmiTransactionPg selectEmibyIdService(long emiId) throws EmiTransactionNotFoundException;
	List<EmiTransactionPg> selectEmiByDateService(Date datefrom, Date datetill) throws EmiTransactionNotFoundException;
}
