package com.example.demo.layer3;

import java.util.List;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;

public interface CustBasicDetailsRepo {

	void registerCustomer(CustBasicDetailsPg registerCust);
	void insertCustomerObject(CustBasicDetailsPg insertCust);
	CustBasicDetailsPg loginCustomer(CustBasicDetailsPg verifyCust) throws CustomerNotFoundException;
	List<CustBasicDetailsPg> selectAllCustomer() throws CustomerNotFoundException;
	CustBasicDetailsPg selectCustomerById(Long id) throws CustomerNotFoundException;
	CustBasicDetailsPg selectCustomerByMobile(String mobile) throws CustomerNotFoundException;
	CustBasicDetailsPg selectCustomerByEmail(String emailId) throws CustomerNotFoundException;
	List<CustBasicDetailsPg> selectCustomerByNationality(String nationality) throws CustomerNotFoundException;
	List<CustBasicDetailsPg> selectCustomerByNetSalary(Integer salary) throws CustomerNotFoundException;
	
}
