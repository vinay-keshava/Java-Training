package org.sample.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.sample.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
	@Autowired
	Student student;
	@Autowired
	EntityManagerFactory emf;
	EntityManager em;
	
	EntityTransaction et;
	public Student saveStudent(Student s) {
		em=emf.createEntityManager();
		et=em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		return s;
		
	}
}
