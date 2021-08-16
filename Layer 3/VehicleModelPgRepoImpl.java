package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.VehicleModelPg;
@Repository
public class VehicleModelPgRepoImpl extends BaseRepository implements VehicleModelPgRepo {
	public VehicleModelPgRepoImpl() {
		System.out.println("Started");
	}
	@Transactional
	@Override
	public VehicleModelPg selectVehicleById(Long id) {
		EntityManager entityManager = getEntityManager();
		System.out.println("Repo Impl-Select By Vehicle Model Id");
		return entityManager.find(VehicleModelPg.class,id);
	}
	@Transactional
	@Override
	public List<VehicleModelPg> selectByVehicleType(String vType) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from VehicleModelPg e where e.vehicleType = :vType");
		query.setParameter("vType", vType);
		List<VehicleModelPg> selectByVehicleType = query.getResultList();
		System.out.println("Repo Impl-Select By Vehicle Type");
		return selectByVehicleType;
	}
	@Transactional
	@Override
	public List<VehicleModelPg> selectByVehicleCName(String cName) {
		System.out.println("Repo Impl-Select By Vehicle CName");
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from VehicleModelPg e where e.vehicleCompanyName = :cName");
		query.setParameter("cName", cName);
		List<VehicleModelPg> selectByVehicleCName = query.getResultList();
		return selectByVehicleCName;
	}
	@Transactional
	@Override
	public List<VehicleModelPg> selectByVehicleMName(String mName) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from VehicleModelPg e where e.modelName = :mName");
		query.setParameter("mName", mName);
		List<VehicleModelPg> selectByVehicleMName = query.getResultList();
		System.out.println("Repo Impl-Select By Vehicle mName");
		return selectByVehicleMName;
	}
	@Override
	public List<VehicleModelPg> selectAllModels() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from VehicleModelPg e");
		List<VehicleModelPg> selectAllModels = query.getResultList();
		return selectAllModels;
	}
//	@Override
//	public List<VehicleModelPg> selectAllCompanies() {
//		EntityManager entityManager = getEntityManager();
//		Query query = entityManager.createQuery("select e.vehicleCompanyName from VehicleModelPg e");
//		List<VehicleModelPg> selectAllCompanies = query.getResultList();
//		return selectAllCompanies;
//	}
	@Transactional
	@Override
	public void insertVehicleCompany(VehicleModelPg newCompany) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(newCompany); 
		System.out.println("NewCompany inserted..."+newCompany);		
	}
	@Override
	public void insertVehicleModel(VehicleModelPg newModel) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(newModel); 
		System.out.println("newModel inserted..."+newModel);		
	}
//	@Override
//	public void insertVehicleDet(VehicleModelPg newDet) {
//		EntityManager entityManager = getEntityManager();
//		entityManager.persist(newDet); 
//		System.out.println("newModel inserted..."+newDet);		
//	}
}
