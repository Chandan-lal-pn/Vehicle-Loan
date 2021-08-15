package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;

public interface CustBasicDetailsPgService {

	void registerCustomerService(CustBasicDetailsPg registerCust);
	void insertCustomerForm2Service(CustBasicDetailsPg insertCust);
	void insertCustomerObjectService(CustBasicDetailsPg insertCust);
	CustBasicDetailsPg loginCustomerService(CustBasicDetailsPg verifyCust) throws CustomerNotFoundException;
	List<CustBasicDetailsPg> selectAllCustomerService() throws CustomerNotFoundException;
	CustBasicDetailsPg selectCustomerByIdService(Long id) throws CustomerNotFoundException;
	CustBasicDetailsPg selectCustomerByMobileService(String mobile) throws CustomerNotFoundException;
	CustBasicDetailsPg selectCustomerByEmailService(String emailId) throws CustomerNotFoundException;
	List<CustBasicDetailsPg> selectCustomerByNationalityService(String nationality) throws CustomerNotFoundException;
	List<CustBasicDetailsPg> selectCustomerByNetSalaryService(Integer salary) throws CustomerNotFoundException;
}
