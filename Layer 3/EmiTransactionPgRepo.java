package com.example.demo.layer3;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer3.exceptions.EmiTransactionNotFoundException;

@Repository
public interface EmiTransactionPgRepo{

	void insertEmi(EmiTransactionPg insertEmi,long loanId) throws EmiTransactionNotFoundException;

	List <EmiTransactionPg> getAllEmis() throws EmiTransactionNotFoundException;
	
	List<EmiTransactionPg> selectEmiByLoanPaymentId(long id) throws EmiTransactionNotFoundException;

	EmiTransactionPg selectEmibyId(long emiId) throws EmiTransactionNotFoundException;

	List<EmiTransactionPg> selectEmiByDate(Date datefrom, Date datetill) throws EmiTransactionNotFoundException;
}
