package com.example.demo.layer5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.CustBasicDetailsPgRepoImpl;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;
import com.example.demo.layer4.CustBasicDetailsPgServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/cust/")
public class CustBasicDetailsPgJPAController extends BaseRepository{

	@Autowired
	CustBasicDetailsPgServiceImpl custService;
	
	public CustBasicDetailsPgJPAController(){
		System.out.println("Customer JPA constructor running...");
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "greet")
	String greetEmployee() {
		return "Hello Customer"; // connect to the DB also via spring JPA
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllCust")
	public List<CustBasicDetailsPg> selectAllCust(){
		System.out.println("Customer JPA selectAllCust() invoked");
		try {
			return custService.selectAllCustomerService();
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getCustById/{custId}")
	public CustBasicDetailsPg selectCustById(@PathVariable Long custId) {
		System.out.println("Customer JPA selectCustById() invoked ");
		try {
			return custService.selectCustomerByIdService(custId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getCustByMobile/{mobile}")
	public CustBasicDetailsPg selectCustByMobile(@PathVariable String mobile) {
		System.out.println("Customer JPA selectCustByMobile() invoked ");
		try {
			return custService.selectCustomerByMobileService(mobile);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getCustByEmail/{email}")
	public CustBasicDetailsPg selectCustByEmailId(@PathVariable String email) {
		System.out.println("Customer JPA selectCustByEmail() invoked ");
		try {
			return custService.selectCustomerByEmailService(email);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value="regisCust")
	public String resgisterCustomer(@RequestBody CustBasicDetailsPg regisCust) {
	
		System.out.println("Cust jpa");
		custService.registerCustomerService(regisCust);
		return "jpa true";
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="loginCust")
	public CustBasicDetailsPg loginCustomer(@RequestBody CustBasicDetailsPg verifyCust)
	{
		System.out.println("CustBasic JPA loginCustomer() invoked");
		try {
			return custService.loginCustomerService(verifyCust);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	@PutMapping
//	@ResponseBody
//	@RequestMapping(value="custAppForm1/{dob}/{gender}/{mobile}/{address}/{state}/{city}/{pincode}/{nationality}")
//	public String insertCustomerApplicationForm1(@PathVariable String dob,@PathVariable String gender,@PathVariable String mobile,@PathVariable String address,@PathVariable String state,@PathVariable String city,@PathVariable String pincode,@PathVariable String nationality) {
//		System.out.println("JPA FORM1 INVOKED");
//		CustBasicDetailsPg temp= (CustBasicDetailsPg) getEntityManager().createQuery("select c from CustBasicDetailsPg c where mobile=: mob").setParameter("mob", mobile).getSingleResult();
//		Date date = null;
//		try {
//			date = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//		temp.setDob(date);		
//		temp.setGender(gender);
//		temp.setResidenceAddress(address);
//		temp.setResidenceState(state);
//		temp.setResidenceCity(city);
//		temp.setPinCode(pincode);
//		temp.setNationality(nationality);
//		custService.insertCustomerObjectService(temp);
//		return ("JPA FORM1 COMPLETE");
//	}
	
//	@PutMapping
//	@ResponseBody
//	@RequestMapping(value="custAppForm2/{orgName}/{typeEmploy}/{salaryPa}/{emiCount}/{emiAmount}/{mobile}")
//	public String insertCustomerApplicationForm2(@PathVariable String orgName,@PathVariable String typeEmploy,@PathVariable Integer salaryPa,@PathVariable Integer emiCount,@PathVariable Integer emiAmount,@PathVariable String mobile) {
//		System.out.println("JPA FORM2 INVOKED");
//		CustBasicDetailsPg temp= (CustBasicDetailsPg) getEntityManager().createQuery("select c from CustBasicDetailsPg c where mobile=: mob").setParameter("mob", mobile).getSingleResult(); 
//			
//		temp.setEmployerName(orgName);
//		temp.setTypeOfEmployment(typeEmploy);
//		temp.setSalaryPa(salaryPa);
//		temp.setExistingEmisCount(emiCount);
//		temp.setExistingEmisAmount(emiAmount);
//		custService.insertCustomerForm2Service(temp);
//		return ("JPA FORM2 COMPLETE");
//	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="addCustObject")
	public String insertCustomerObject(@RequestBody CustBasicDetailsPg custObj) {
		System.out.println("JPA insertCustomerObject() INVOKED");
		custService.insertCustomerObjectService(custObj);
		return ("JPA CUST OBJECT ADDED");
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="addCustAppForm2")
	public String insertCustomerApplicationForm(@RequestBody CustBasicDetailsPg custObj) {
		System.out.println("JPA insertCustomerObject() INVOKED");
		custService.insertCustomerForm2Service(custObj);
		return ("JPA CUST OBJECT ADDED");
	}
	
}
