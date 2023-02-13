package mapping.one.to.one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vinay");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et=em.getTransaction();

	public void insertPerson(Aadhar a, Person p) {
		et.begin();
		em.persist(p);
		em.persist(a);
		et.commit();

	}

	public void delete(int id) {
		Person p = em.find(Person.class, id);
		id = p.getA().getId();
		Aadhar a = em.find(Aadhar.class, id);
		et.begin();
		em.remove(a);
		em.remove(p);
		et.commit();

	}

	public Person display(int id) {
		Person p = em.find(Person.class, id);
		System.out.print(p.getEmailId()+""+p.getId()+""+p.getA()+"\n");
		return p;
	}

	public void update(int id, String email) {
		et.begin();
		Person p = em.find(Person.class, id);
		p.setEmailId(email);
		em.merge(p);
		et.commit();
	}
}
