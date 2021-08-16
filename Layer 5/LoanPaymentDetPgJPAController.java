package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer2.ApplicationDetPg;
import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.LoanPaymentDetPg;
import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;
import com.example.demo.layer3.exceptions.LoanPaymentNotFoundException;
import com.example.demo.layer4.LoanPaymentDetPgServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/loanPayments/")
public class LoanPaymentDetPgJPAController {

	@Autowired
	LoanPaymentDetPgServiceImpl loanPayServe;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllLoanPay")
	public List<LoanPaymentDetPg> getAllLoanPayments(){
		System.out.println("LOAN PAY JPA GETALLPAYMENTS");
		
			try {
				return loanPayServe.getAllLoanPaymentsService();
			} catch (LoanPaymentNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getLoanPayByCustId/{custId}")
	public List<LoanPaymentDetPg> getLoanPaymentsByCustID(@PathVariable long custId){
		System.out.println("LOAN PAY JPA GETALLPAYMENTS");
		
			try {
				return loanPayServe.getLoanPaymentByCustIdService(custId);
			} catch (LoanPaymentNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getLoanPayByAppId/{appId}")
	public LoanPaymentDetPg getLoanPaymentByAppId(@PathVariable long appId){
		System.out.println("LOAN PAY JPA GETALLPAYMENTS");
		
			try {
				return loanPayServe.getLoanPaymentByApplicationIdService(appId);
			} catch (LoanPaymentNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return null;
	}
	
	@ResponseBody
	@PostMapping(path="/newLoan/{appId}/{adminId}")
	public String newLoanEntry(@PathVariable long appId,@PathVariable long adminId) {
	
		System.out.println("loan pay jpa insert new");
		loanPayServe.newLoanService(appId, adminId);
		return "jpa true";
	}
	
	@ResponseBody
	@PostMapping(path="/updateLoan/{loanId}/{emiId}")
	public String updateLoanEntryOnEmiPay(@PathVariable long loanId,@PathVariable long emiId) {
	
		System.out.println("loan pay jpa insert new");
		loanPayServe.updateAfterEmiService(loanId, emiId);
		return "jpa true";
	}
}
