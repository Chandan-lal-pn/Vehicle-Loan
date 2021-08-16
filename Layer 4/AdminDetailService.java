package com.example.demo.layer4;

import java.util.List;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer3.exceptions.NoAdminFoundException;

public interface AdminDetailService {

	List<AdminDetail> getAllAdmin() throws NoAdminFoundException;
	AdminDetail loginAdmin(AdminDetail adm) throws NoAdminFoundException;
	AdminDetail editAdmin(AdminDetail adm) throws NoAdminFoundException;

}
