package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer3.exceptions.NoAdminFoundException;
import com.example.demo.layer4.AdminDetailServiceImpl;

@CrossOrigin
@Controller
@RequestMapping("/admin/")
public class AdminDetailJPAController {

	@Autowired
	AdminDetailServiceImpl adminServe;

	@GetMapping
	@ResponseBody
	@RequestMapping(value = "logInAdm")
	public AdminDetail loginAdmin(@RequestBody AdminDetail verifyAdm) {
		System.out.println("admin JPA login() invoked");
		try {
			return adminServe.loginAdmin(verifyAdm);
		} catch (NoAdminFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping
	@ResponseBody
	@RequestMapping(value = "editAdmin")
	public AdminDetail editAdminDetail(@RequestBody AdminDetail admObj) {
		System.out.println("JPA editAdminDetail() INVOKED");
		try {
			return adminServe.editAdmin(admObj);
		} catch (NoAdminFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "getAllAdmin")
	public List<AdminDetail> getAllAdmin(){
		System.out.println(" JPA GETALLadmin");
		
			try {
				return adminServe.getAllAdmin();
			} catch (NoAdminFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		return null;
	}
}
