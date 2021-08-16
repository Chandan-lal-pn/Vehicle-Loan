package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.VehicleModelPg;

@Service
public interface VehicleModelPgService {
	
	void insertVehicleCompanyService(VehicleModelPg newCompany);
	void insertVehicleModelService(VehicleModelPg newModel);
//	void insertVehicleDetService(VehicleModelPg newDet);
	List<VehicleModelPg> selectAllModelsService();
//	List<VehicleModelPg> selectAllCompaniesService();
	VehicleModelPg selectVehicleByIdService(Long id);
	List<VehicleModelPg> selectByVehicleTypeService(String vType);
	List<VehicleModelPg> selectByVehicleCNameService(String cName);
	List<VehicleModelPg> selectByVehicleMNameService(String mName);
}
