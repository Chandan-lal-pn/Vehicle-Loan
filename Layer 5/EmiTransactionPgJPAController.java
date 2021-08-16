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

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.EmiTransactionPg;
import com.example.demo.layer3.CustBasicDetailsPgRepoImpl;
import com.example.demo.layer3.EmiTransactionPgRepoImpl;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;
import com.example.demo.layer3.exceptions.EmiTransactionNotFoundException;
import com.example.demo.layer4.EmiTransactionPgServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/emis/")
public class EmiTransactionPgJPAController {

	@Autowired
//	EmiTransactionPgRepoImpl emiRepo;
	EmiTransactionPgServiceImpl emiRepoService;
	public EmiTransactionPgJPAController(){
		System.out.println("Emis JPA constructor running...");
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getEmiByLoanId/{loanId}")
	public List<EmiTransactionPg> selectEmiByLoanId(@PathVariable Long loanId) {
		System.out.println("getEmployee()...method ");
		try {
			return emiRepoService.selectEmiByLoanPaymentIdService(loanId);
		} catch (EmiTransactionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllEmis")
	public List<EmiTransactionPg> selectEmiByLoanId() {
		System.out.println("getEmployee()...method ");
		try {
			return emiRepoService.getAllEmisService();
		} catch (EmiTransactionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@ResponseBody
	@PostMapping(path="/createTransaction/{loanId}")
	public String resgisterCustomer(@PathVariable Long loanId,@RequestBody EmiTransactionPg newT) {
	
		System.out.println("emi jpa");
		try {
			emiRepoService.insertEmiService(newT, loanId);
		} catch (EmiTransactionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jpa true";
	}
}
