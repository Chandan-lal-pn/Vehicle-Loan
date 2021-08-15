package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.VehicleModelPg;
import com.example.demo.layer3.VehicleModelPgRepoImpl;

@Service
public class VehicleModelPgServiceImpl implements VehicleModelPgService{
	
	@Autowired
	VehicleModelPgRepoImpl vmodRepo;

	@Override
	public VehicleModelPg selectVehicleByIdService(Long id) {
		return null;
	}

	@Override
	public List<VehicleModelPg> selectByVehicleTypeService(String vType) {
		return vmodRepo.selectByVehicleType(vType);
	}

	@Override
	public List<VehicleModelPg> selectByVehicleCNameService(String cName) {
		return vmodRepo.selectByVehicleCName(cName);
	}

	@Override
	public List<VehicleModelPg> selectByVehicleMNameService(String mName) {
		return vmodRepo.selectByVehicleMName(mName);
	}

	@Override
	public List<VehicleModelPg> selectAllModelsService() {
		// TODO Auto-generated method stub
		return vmodRepo.selectAllModels();
	}

//	@Override
//	public List<VehicleModelPg> selectAllCompaniesService() {
//		// TODO Auto-generated method stub
//		return vmodRepo.selectAllCompanies();
//	}

	@Override
	public void insertVehicleCompanyService(VehicleModelPg newCompany) {
		vmodRepo.insertVehicleCompany(newCompany);
		System.out.println("New Company Inserted");
		
	}

	@Override
	public void insertVehicleModelService(VehicleModelPg newModel) {
		vmodRepo.insertVehicleModel(newModel);
		System.out.println("New Model Inserted");
		
	}

//	@Override
//	public void insertVehicleDetService(VehicleModelPg newDet) {
//		vmodRepo.insertVehicleModel(newDet);
//		System.out.println("New Data Inserted");		
//	}
//		
	
}
