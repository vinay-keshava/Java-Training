package org.sample.aadhar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.sample.customer.Customer;

public class PersonDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	/*savePersonAndAadhar*/
	public Person savePerson(Person person,Aadhar aadhar)
	{ 
	entityManager=entityManagerFactory.createEntityManager();
	entityTransaction=entityManager.getTransaction();
	
	entityTransaction.begin();
entityManager.persist(person);
entityManager.persist(aadhar);

entityTransaction.commit();
System.out.println("......Data Stored.........");
	
	
return person;

		
	}
	public void deleteById(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Aadhar a=entityManager.find(Aadhar.class ,id);
		Person p1=entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(a);
		entityManager.remove(p1);
		entityTransaction.commit();
	}
	
	public void updateById(String name,long Aadhar,int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		Person p1=entityManager.find(Person.class ,id);
		Aadhar a1=entityManager.find(Aadhar.class, );
		p1.setName(name);
		a1.setAddress(name).set
	}
}