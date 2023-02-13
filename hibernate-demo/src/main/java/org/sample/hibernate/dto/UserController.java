package org.sample.hibernate.dto;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserController {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
//		User user= entityManager.find(User.class, 102);
		User user = new User();
		user.setId(105);
		user.setName("Vinay");
		user.setEmail("hello@falcon.in");
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		System.out.println("Data stored");
	}
}
