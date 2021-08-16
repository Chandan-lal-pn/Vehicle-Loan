package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.AdminDetail;
import com.example.demo.layer3.exceptions.NoAdminFoundException;

@Repository
public class AdminDetailRepoImpl extends BaseRepository implements AdminDetailRepo {

	@Transactional
	@Override
	public List<AdminDetail> getAllAdmin() throws NoAdminFoundException {
		// TODO Auto-generated method stub
		System.out.println("admin repo getall");
		return getEntityManager().createQuery(" from AdminDetail").getResultList();
	}

	@Transactional
	@Override
	public AdminDetail loginAdmin(AdminDetail adm) throws NoAdminFoundException {
		// TODO Auto-generated method stub
//		AdminDetail temp= (AdminDetail) getEntityManager()
//				.createQuery("select a from AdminDetail a where a.adminUserid =: userId and a.adminPassword =: pass")
//				.setParameter("userId", adm.getAdminUserid()).setParameter("pass", adm.getAdminPassword()).getSingleResult();
//		if(temp != adm) throw new NoAdminFoundException("not verified");
//		else return temp;
//		
		return (AdminDetail) getEntityManager()
				.createQuery("select a from AdminDetail a where a.adminUserid =: userId and a.adminPassword =: pass")
				.setParameter("userId", adm.getAdminUserid()).setParameter("pass", adm.getAdminPassword()).getSingleResult();
	}

	@Transactional
	@Override
	public AdminDetail editAdmin(AdminDetail adm) throws NoAdminFoundException {
		// TODO Auto-generated method stub
		AdminDetail temp = getEntityManager().find(AdminDetail.class, adm.getAdminId());
		return getEntityManager().merge(temp);
	}

}
