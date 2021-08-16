package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer3.AdminDetailRepoImpl;
import com.example.demo.layer3.exceptions.NoAdminFoundException;

@Service
public class AdminDetailServiceImpl implements AdminDetailService {

	@Autowired
	AdminDetailRepoImpl adminRepo;
	
	@Override
	public List<AdminDetail> getAllAdmin() throws NoAdminFoundException {
		// TODO Auto-generated method stub
		return adminRepo.getAllAdmin();
	}

	@Override
	public AdminDetail loginAdmin(AdminDetail adm) throws NoAdminFoundException {
		// TODO Auto-generated method stub
		return adminRepo.loginAdmin(adm);
	}

	@Override
	public AdminDetail editAdmin(AdminDetail adm) throws NoAdminFoundException {
		// TODO Auto-generated method stub
		return adminRepo.editAdmin(adm);
	}

	
}
