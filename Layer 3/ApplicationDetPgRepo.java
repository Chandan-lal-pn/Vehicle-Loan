package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer3.exceptions.ApplicationNotFoundException;

@Repository
public interface ApplicationDetPgRepo {

	void generateApplication(ApplicationDetPg app, long custId, long modelId, long loanId);
	void updateApplication(ApplicationDetPg app, long custId, long modelId, long loanId);
	List<ApplicationDetPg> getAllApplication() throws ApplicationNotFoundException;
	List<ApplicationDetPg> getApplicationByCustId(long custId) throws ApplicationNotFoundException;
	List<ApplicationDetPg> getApplicationByCustMobile(String mobile) throws ApplicationNotFoundException;
	List<ApplicationDetPg> getApplicationByCustEmail(String email) throws ApplicationNotFoundException;
	String deleteApplication(long appId) throws ApplicationNotFoundException;
	ApplicationDetPg updateApplicationStatus(long appId, String applicationStatus) throws ApplicationNotFoundException;
	
}
