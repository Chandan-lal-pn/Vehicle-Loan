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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer3.exceptions.LoanAmountNotFoundException;
import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer4.LoanAmountsPgServiceImpl;


@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/loanAmt")
public class LoanAmountsJPAController {
	
	@Autowired
	LoanAmountsPgServiceImpl loanAmountService;

	public LoanAmountsJPAController() {
		System.out.println("Inside LoanAmountsJPAController..layer5");
	}
	
	@ResponseBody
	@DeleteMapping(value="/deleteLoanAmount/{loanAmountId}")
	public void deleteLoanAmount(@PathVariable long loanAmountId) {
		System.out.println("deleteLoanAmount..level5");
			loanAmountService.deleteLoanAmountService(loanAmountId);
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAllLoanAmt")
	public List<LoanAmountsPg> selectAllLoanAmounts(){
		System.out.println("selectAllLoanAmounts Layer 5");
		return loanAmountService.selectAllLoanAmountsService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getLoanAmtById/{loanAmountId}")
	public LoanAmountsPg selectByloantypeid(@PathVariable long loanAmountId){
		System.out.println("selectByloantypeid Layer 5");
		try {
			return loanAmountService.selectByloantypeidService(loanAmountId);
		} catch (LoanAmountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getLoanAmtByType/{loanType}")
	public List<LoanAmountsPg> selectByloantypeid(@PathVariable String loanType){
		System.out.println("selectByloanType Layer 5");
		try {
			return loanAmountService.selectByloantypeService(loanType);
		} catch (LoanAmountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getLoanAmtByMinSalary/{salary}")
	public List<LoanAmountsPg> selectByMinSalary(@PathVariable int salary){
		System.out.println("selectByMinSalary Layer 5");
		try {
			return loanAmountService.selectByMinimumSalaryReqService(salary);
		} catch (LoanAmountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getLoanAmtByPrice/{price}")
	public List<LoanAmountsPg> selectByPrice(@PathVariable int price){
		System.out.println("selectByPrice Layer 5");
		try {
			return loanAmountService.selectByPriceService(price);
		} catch (LoanAmountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/greet")
	String greetEmployee() {
	return "Hello LoanAmount"; // connect to the DB also via spring JPA
	}
	

	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addLoanAmt")
	public String insertLoanAmount(@RequestBody LoanAmountsPg loanAmt) {
		System.out.println("insertLoanAmount(@RequestBody loanAmt)...method ");
		loanAmountService.insertLoanAmountService(loanAmt);
		return "Employee Added Successfulyy";
	}

}
