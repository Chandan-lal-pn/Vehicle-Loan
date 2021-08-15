package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.CustBasicDetailsPgRepoImpl;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;

@Service
public class CustBasicDetailsPgServiceImpl extends BaseRepository implements CustBasicDetailsPgService {

	@Autowired
	CustBasicDetailsPgRepoImpl custRepo;
	
	@Override
	public void registerCustomerService(CustBasicDetailsPg registerCust) {
		// TODO Auto-generated method stub
		custRepo.registerCustomer(registerCust);
		
	}

//	@Override
//	public void insertCustomerForm1Service(CustBasicDetailsPg insertCust) {
//		// TODO Auto-generated method stub
//		custRepo.insertCustomerObject(insertCust);
//
//	}

	@Override
	public void insertCustomerForm2Service(CustBasicDetailsPg cust) {
		// TODO Auto-generated method stub
		CustBasicDetailsPg temp= (CustBasicDetailsPg) getEntityManager().createQuery("select c from CustBasicDetailsPg c where mobile=: mob").setParameter("mob", cust.getMobile()).getSingleResult();
		temp.setDob(cust.getDob());		
		temp.setGender(cust.getGender());
		temp.setResidenceAddress(cust.getResidenceAddress());
		temp.setResidenceState(cust.getResidenceState());
		temp.setResidenceCity(cust.getResidenceCity());
		temp.setPinCode(cust.getPinCode());
		temp.setNationality(cust.getNationality());
		temp.setEmployerName(cust.getEmployerName());
		temp.setTypeOfEmployment(cust.getTypeOfEmployment());
		temp.setSalaryPa(cust.getSalaryPa());
		temp.setExistingEmisCount(cust.getExistingEmisCount());
		temp.setExistingEmisAmount(cust.getExistingEmisAmount());
		custRepo.insertCustomerObject(temp);
	}

	@Override
	public void insertCustomerObjectService(CustBasicDetailsPg insertCust) {
		// TODO Auto-generated method stub
		custRepo.insertCustomerObject(insertCust);
	}

	@Override
	public List<CustBasicDetailsPg> selectAllCustomerService() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		try {
			return custRepo.selectAllCustomer();
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CustBasicDetailsPg selectCustomerByIdService(Long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		try {
			return custRepo.selectCustomerById(id);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CustBasicDetailsPg selectCustomerByMobileService(String mobile) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		try {
			return custRepo.selectCustomerByMobile(mobile);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CustBasicDetailsPg selectCustomerByEmailService(String emailId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		try {
			return custRepo.selectCustomerByEmail(emailId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustBasicDetailsPg> selectCustomerByNationalityService(String nationality)
			throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustBasicDetailsPg> selectCustomerByNetSalaryService(Integer salary) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustBasicDetailsPg loginCustomerService(CustBasicDetailsPg verifyCust) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return custRepo.loginCustomer(verifyCust);
	}

}
