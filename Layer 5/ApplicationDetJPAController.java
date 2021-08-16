package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer3.exceptions.ApplicationNotFoundException;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;
import com.example.demo.layer3.exceptions.EmiTransactionNotFoundException;
import com.example.demo.layer4.ApplicationDetPgServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/app/")
public class ApplicationDetJPAController {

	@Autowired
	ApplicationDetPgServiceImpl appServe;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllApp")
	public List<ApplicationDetPg> getAllApplication(){
		System.out.println("application jpa getallApplication invoked");
		return appServe.getAllApplicationService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAppById/{custId}")
	public List<ApplicationDetPg> getAppById(@PathVariable long custId){
		System.out.println("application jpa getallApplication invoked");
		return appServe.getApplicationByCustIdService(custId);
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAppByMobile/{mobile}")
	public List<ApplicationDetPg> getAppByMobile(@PathVariable String mobile){
		System.out.println("application jpa getallApplication invoked");
		return appServe.getApplicationByCustMobileService(mobile);
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAppByEmail/{email}")
	public List<ApplicationDetPg> getAppByEmail(@PathVariable String email){
		System.out.println("app jpa getByemail invoked");
		return appServe.getApplicationByCustMobileService(email);
	}
	
	@ResponseBody
	@PostMapping(path="/createNewApp/{custId}/{modelId}/{loanId}")
	public String createNewApplication(@PathVariable long custId,@PathVariable long modelId,@PathVariable long loanId,@RequestBody ApplicationDetPg newApp) throws ApplicationNotFoundException {
	
		System.out.println("app jpa creaatenewapp invoked");
		appServe.generateApplicationService(newApp, custId, modelId, loanId);
		return "jpa true";
	}
	
	@ResponseBody
	@PostMapping(path="/updateApp/{custId}/{modelId}/{loanId}")
	public String updateExistingApplication(@PathVariable long custId,@PathVariable long modelId,@PathVariable long loanId,@RequestBody ApplicationDetPg newApp) throws ApplicationNotFoundException {
	
		System.out.println("app jpa update invoked");
		appServe.generateApplicationService(newApp, custId, modelId, loanId);
		return "jpa true";
	}
	
	@ResponseBody
	@PostMapping(path="/updateApp/{appId}/{appStatus}")
	public String updateExistingApplication(@PathVariable long appId,@PathVariable String appStatus) throws ApplicationNotFoundException {
	
		System.out.println("app jpa update status invoked");
		appServe.updateApplicationStatusService(appId, appStatus);
		return "jpa true";
	}
	
	@ResponseBody
	@DeleteMapping(value="/delApp/{appId}")
	public String deleteApplication(@PathVariable long appId) {
		System.out.println("app jpa del invoked");
		try {
			return appServe.deleteApplicationService(appId);
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "application del true";
	}
}
