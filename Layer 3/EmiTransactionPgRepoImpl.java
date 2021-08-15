package com.example.demo.layer3;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer3.exceptions.EmiTransactionNotFoundException;

@Repository
public class EmiTransactionPgRepoImpl extends BaseRepository implements EmiTransactionPgRepo {

	@Transactional
	@Override
	public void insertEmi(EmiTransactionPg insertEmi,long loanId) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		LoanPaymentDetPg temp = getEntityManager().find(LoanPaymentDetPg.class, loanId);
		insertEmi.setTransactionDatetime(new Timestamp(System.currentTimeMillis()));
		insertEmi.setLoanPaymentDetPg(temp);
		getEntityManager().persist(insertEmi);

	}

	@Transactional
	@Override
	public List<EmiTransactionPg> selectEmiByLoanPaymentId(long id) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		LoanPaymentDetPg lpd = new LoanPaymentDetPg();
		lpd.setLoanPaymentId(id);
		return getEntityManager().createQuery("select e from EmiTransactionPg e where e.loanPaymentDetPg =: loanObj").setParameter("loanObj", lpd ).getResultList();
	}

	@Transactional
	@Override
	public EmiTransactionPg selectEmibyId(long emiId) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		return getEntityManager().find(EmiTransactionPg.class, emiId);
	}

	@Transactional
	@Override
	public List<EmiTransactionPg> selectEmiByDate(Date datefrom, Date datetill) throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		Timestamp from = new Timestamp(datefrom.getTime());
		Timestamp till = new Timestamp(datetill.getTime());
		return getEntityManager().createQuery("select e from EmiTransactionPg e where e.transactionDatetime BETWEEN from and till")
				.setParameter("from", from).setParameter("till", till).getResultList();
	}

	@Transactional
	@Override
	public List<EmiTransactionPg> getAllEmis() throws EmiTransactionNotFoundException {
		// TODO Auto-generated method stub
		return getEntityManager().createQuery(" from EmiTransactionPg").getResultList();
	}

}
