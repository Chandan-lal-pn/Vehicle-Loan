package com.example.demo.layer3;

import java.util.List;

import com.example.demo.layer2.VehicleModelPg;

public interface VehicleModelPgRepo {
	
	
	void insertVehicleCompany(VehicleModelPg newCompany);
	void insertVehicleModel(VehicleModelPg newModel);
//	void insertVehicleDet(VehicleModelPg newDet);
	List<VehicleModelPg> selectAllModels();
//	List<VehicleModelPg> selectAllCompanies();
	VehicleModelPg selectVehicleById(Long id);
	List<VehicleModelPg> selectByVehicleType(String vType);
	List<VehicleModelPg> selectByVehicleCName(String cName);
	List<VehicleModelPg> selectByVehicleMName(String mName);
}
