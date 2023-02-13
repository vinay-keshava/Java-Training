package org.sample.hibernate.dto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserNameParameterController {

	public static void main(String[] args) {
		EntityManagerFactory entitiyManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager  entityManager= entitiyManagerFactory.createEntityManager();
		String query = "SELECT u FROM User u where u.email=:name";

		Query query2 = entityManager.createQuery(query);
		query2.setParameter("name","hello@falcon.in");
		List<User> list = query2.getResultList();
		list.forEach(a -> System.out.println(a.getId() + "\n" + a.getName() + "\n" + a.getEmail() + "\n"));

	}

}
