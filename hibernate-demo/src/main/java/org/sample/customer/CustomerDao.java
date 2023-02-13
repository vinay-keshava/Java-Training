package org.sample.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.sample.hibernate.dto.User;

public class CustomerDao {

	EntityManagerFactory entitiyManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	public Customer saveCustomer(Customer customer) {
		entityManager = entitiyManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		if (customer != null) {
			entityTransaction.begin();
			entityManager.persist(customer);
			entityTransaction.commit();
			System.out.println("------- Data Stored ---------");
		} else {
			System.out.println("----------------Please set the data in customer object--------------");
		}
		return customer;
	}
	
	public Customer updateById(int id,String name,String email) {
		entityManager = entitiyManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Customer c=entityManager.find(Customer.class ,id);
		c.setName(name);
		c.setEmail(email);
		if (c!= null) {
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
			System.out.println("------- Data Stored ---------");
		} 
		else {System.out.println("----------------Please set the data in customer object--------------");}
		return c;
	}
	
	
	public Customer deleteById(int id) {
		entityManager = entitiyManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Customer c=entityManager.find(Customer.class ,id);
		if (c!= null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			System.out.println("------- Data Removed---------");
		} 
		else {System.out.println("----------------Please Check the data in customer object--------------");}
		return c;
	}
	
	public List<Customer> displayAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
	String query="SELECT c FROM Customer c";
		Query query2=entityManager.createQuery(query);
		List<Customer> list =query2.getResultList();
//		list.forEach(a->System.out.println(a.getId()+"\n"+a.getName()+"\n"+a.getEmail()));
		return list;
	}
	

}
