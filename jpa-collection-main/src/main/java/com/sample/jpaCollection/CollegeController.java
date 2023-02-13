package com.sample.jpaCollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CollegeController {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vinay");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		Branch b1=new Branch();	
		b1.setCapacity(180);
		b1.setName("CSE");
		b1.setNoOfFaculty(20);
		College c1=new College();
		c1.setColCode(2121);
		c1.setName("AIET");
		c1.getBranch().add(b1);
		em.persist(c1);
		et.commit();
		emf.close();
		em.close();
	}
}
