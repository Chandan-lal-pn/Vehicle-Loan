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

import com.example.demo.layer2.CustBasicDetailsPg;
import com.example.demo.layer2.LoanAmountsPg;
import com.example.demo.layer2.VehicleModelPg;
import com.example.demo.layer3.VehicleModelPgRepo;
import com.example.demo.layer3.VehicleModelPgRepoImpl;
import com.example.demo.layer3.exceptions.CustomerNotFoundException;
import com.example.demo.layer3.exceptions.VehicleNotFoundException;
import com.example.demo.layer4.VehicleModelPgServiceImpl;


@CrossOrigin
@Controller // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/vmod/")
public class VehicleModelPgJPAController {
	
	@Autowired
	VehicleModelPgServiceImpl vmodRepoService;
//	VehicleModelPgRepoImpl vmodRepo;
	public VehicleModelPgJPAController(){
	System.out.println("Vehicle Model JPA Controller running...");
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/greet")
	String greetEmployee() {
		System.out.println("Vehicle DB Connection Complete JPA Controller");
		return "Vehicle DB Connection Complete"; // connect to the DB also via spring JPA
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getByVehicleType/{vType}")
	public List<VehicleModelPg> selectByVehicleType(@PathVariable String vType) throws VehicleNotFoundException{
		System.out.println("Customer JPA selectByVehicleType() invoked by JPA Controller");
		return vmodRepoService.selectByVehicleTypeService(vType);
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getByVehicleCName/{cName}")
	public List<VehicleModelPg> selectByVehicleCName(@PathVariable String cName) throws VehicleNotFoundException{
		System.out.println("Customer JPA selectByVehicleCName() invoked by JPA Controller");
		return vmodRepoService.selectByVehicleCNameService(cName);
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getByVehicleMName/{mName}")
	public List<VehicleModelPg> selectByVehicleMName(@PathVariable String mName) throws VehicleNotFoundException{
		System.out.println("Customer JPA selectByVehicleMName() invoked by JPA Controller");
		return vmodRepoService.selectByVehicleMNameService(mName);
	}

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllModels")
	public List<VehicleModelPg> selectAllModels() {
		System.out.println("All Models Displayed by JPA Controller");
		return vmodRepoService.selectAllModelsService();
	}
//	@GetMapping
//	@ResponseBody
//	@RequestMapping(value = "/getAllCompanies")
//	public List<VehicleModelPg> selectAllCompanies() {
//		System.out.println("All Companies Displayed by JPA Controller");
//		return vmodRepoService.selectAllCompaniesService();
//	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addCompany")
	public String insertVehicleCompany(@RequestBody VehicleModelPg cName) {
		System.out.println("inserting Vehicle Company");
		vmodRepoService.insertVehicleCompanyService(cName);
		return "Vehicle Company Added Successfulyy";
	}
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addModel")
	public String insertVehicleModel(@RequestBody VehicleModelPg mName) {
		System.out.println("inserting Vehicle Model");
		vmodRepoService.insertVehicleModelService(mName);
		return "Vehicle Model Added Successfulyy";
	}

	}
	 
