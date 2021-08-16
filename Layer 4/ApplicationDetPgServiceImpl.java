package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer3.ApplicationDetPgRepoImpl;
import com.example.demo.layer3.exceptions.ApplicationNotFoundException;

@Service
public class ApplicationDetPgServiceImpl implements ApplicationDetPgService {

	@Autowired
	ApplicationDetPgRepoImpl appRepo;
	
	@Override
	public void generateApplicationService(ApplicationDetPg app, long custId, long modelId, long loanId) {
		// TODO Auto-generated method stub
		System.out.println("app service generate application");
		appRepo.generateApplication(app, custId, modelId, loanId);
	}

	@Override
	public List<ApplicationDetPg> getAllApplicationService() {
		// TODO Auto-generated method stub
		try {
			return appRepo.getAllApplication();
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ApplicationDetPg> getApplicationByCustIdService(long custId) {
		// TODO Auto-generated method stub
		return appRepo.getApplicationByCustId(custId);
	}

	@Override
	public List<ApplicationDetPg> getApplicationByCustMobileService(String mobile) {
		// TODO Auto-generated method stub
		return appRepo.getApplicationByCustMobile(mobile);
	}

	@Override
	public List<ApplicationDetPg> getApplicationByCustEmailService(String email) throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
		return appRepo.getApplicationByCustEmail(email);
	}

	@Override
	public String deleteApplicationService(long appId) throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
		return appRepo.deleteApplication(appId);
	}

	@Override
	public ApplicationDetPg updateApplicationStatusService(long appId, String applicationStatus)
			throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
		return appRepo.updateApplicationStatus(appId, applicationStatus);
	}

}
