package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer2.VehicleModelPg;
import com.example.demo.layer3.exceptions.ApplicationNotFoundException;

@Repository
public class ApplicationDetPgRepoImpl extends BaseRepository implements ApplicationDetPgRepo {

	@Transactional
	@Override
	public void generateApplication(ApplicationDetPg app, long custId, long modelId, long loanId) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg cust = getEntityManager().find(CustBasicDetailsPg.class, custId);
		VehicleModelPg model = getEntityManager().find(VehicleModelPg.class, modelId);
		LoanAmountsPg lType = getEntityManager().find(LoanAmountsPg.class, loanId);
		app.setCustBasicDetailsPg(cust);
		app.setVehicleModelPg(model);
		app.setLoanAmountsPg(lType);
		getEntityManager().persist(app);

	}
	
	@Transactional
	@Override
	public List<ApplicationDetPg> getAllApplication() throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
		List<ApplicationDetPg> ret= getEntityManager().createQuery(" from ApplicationDetPg").getResultList();
		if(ret==null) throw new ApplicationNotFoundException("application not found");
		return ret;
	}

	@Transactional
	@Override
	public List<ApplicationDetPg> getApplicationByCustId(long custId) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg temp= getEntityManager().find(CustBasicDetailsPg.class, custId);
		return  getEntityManager().createQuery("select a from ApplicationDetPg a where a.custBasicDetailsPg=: temp").setParameter("temp", temp).getResultList();
	}

	@Transactional
	@Override
	public List<ApplicationDetPg> getApplicationByCustMobile(String mobile) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg temp = (CustBasicDetailsPg) getEntityManager()
				.createQuery("select c from CustBasicDetailsPg c where mobile=: mob").setParameter("mob", mobile).getSingleResult();
		return getEntityManager().createQuery("select a from ApplicationDetPg a where a.custBasicDetailsPg =: temp").setParameter("temp",temp).getResultList();
	}

	@Transactional
	@Override
	public List<ApplicationDetPg> getApplicationByCustEmail(String email) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg temp = (CustBasicDetailsPg) getEntityManager()
				.createQuery("select c from CustBasicDetailsPg c where emailId=: email").setParameter("email", email).getSingleResult();
		return getEntityManager().createQuery("select a from ApplicationDetPg a where a.custBasicDetailsPg =: temp").setParameter("temp",temp).getResultList();
	}

	@Transactional
	@Override
	public void updateApplication(ApplicationDetPg app, long custId, long modelId, long loanId) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg cust = getEntityManager().find(CustBasicDetailsPg.class, custId);
		VehicleModelPg model = getEntityManager().find(VehicleModelPg.class, modelId);
		LoanAmountsPg lType = getEntityManager().find(LoanAmountsPg.class, loanId);
		app.setCustBasicDetailsPg(cust);
		app.setVehicleModelPg(model);
		app.setLoanAmountsPg(lType);
		getEntityManager().merge(app);
		
	}

	@Transactional
	@Override
	public String deleteApplication(long appId) throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
		ApplicationDetPg temp= getEntityManager().find(ApplicationDetPg.class, appId);
		if(temp == null) {
			throw new ApplicationNotFoundException("application not found");
		}
		else {
			getEntityManager().remove(temp);
		}
		return "application deleted";
	}

	@Transactional
	@Override
	public ApplicationDetPg updateApplicationStatus(long appId, String applicationStatus) throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
		ApplicationDetPg temp= getEntityManager().find(ApplicationDetPg.class, appId);
		if(temp == null) throw new ApplicationNotFoundException("application not found");
		temp.setApplicationStatus(applicationStatus);
		getEntityManager().merge(temp);
		return temp;
			
	}

	
	
	

}
