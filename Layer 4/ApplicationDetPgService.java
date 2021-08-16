package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer3.exceptions.ApplicationNotFoundException;

public interface ApplicationDetPgService {

	void generateApplicationService(ApplicationDetPg app, long custId, long modelId, long loanId);
	List<ApplicationDetPg> getAllApplicationService() throws ApplicationNotFoundException;
	List<ApplicationDetPg> getApplicationByCustIdService(long custId) throws ApplicationNotFoundException;
	List<ApplicationDetPg> getApplicationByCustMobileService(String mobile) throws ApplicationNotFoundException;
	List<ApplicationDetPg> getApplicationByCustEmailService(String email) throws ApplicationNotFoundException;
	String deleteApplicationService(long appId) throws ApplicationNotFoundException;
	ApplicationDetPg updateApplicationStatusService(long appId, String applicationStatus) throws ApplicationNotFoundException;
}
