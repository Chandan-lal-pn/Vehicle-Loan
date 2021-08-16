package com.example.demo.layer3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseRepository {
	
	@PersistenceContext
	public EntityManager entityManager;

	
	public EntityManager getEntityManager() {
		System.out.println("BaseRepository: getting entity manager...");
		return entityManager;
	}

	/*public EntityManagerFactory getEntityManagerFactory() {
		System.out.println("BaseRepository: getting entityManagerFactory");
		return entityManager;
	}*/
	
}
