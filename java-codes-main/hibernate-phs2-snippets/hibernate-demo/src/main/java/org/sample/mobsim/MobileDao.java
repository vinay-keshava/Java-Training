package org.sample.mobsim;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class MobileDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	public Mobile saveMobileSim(Mobile m, List<Sim> list) {
		entityTransaction.begin();
		entityManager.persist(m);
		for (Sim sim : list) {
			entityManager.persist(sim);
		}
		entityTransaction.commit();
		return m;
	}

	public Mobile updateMobileSim(int id, String name, String serviceprovider,String simname) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		mobile.setName(name);
		entityTransaction.begin();
		for (Sim s : mobile.getList()) {
			if(s.getName().equals(simname)) {
			s.setProvider(serviceprovider);
			entityManager.merge(s);
			}
		}
		entityManager.merge(mobile);
		entityTransaction.commit();
		return mobile;
	}

	public Mobile getById(int id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		return mobile;
	}

	public Mobile deleteById(int id) {
		Mobile mobile = entityManager.find(Mobile.class, id);
		entityTransaction.begin();
		for (Sim s : mobile.getList()) {
			entityManager.remove(s);
		}
		entityManager.remove(mobile);
		entityTransaction.commit();
		return mobile;
	}

}

