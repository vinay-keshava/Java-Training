package mapping.one.to.many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmpDao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vinay");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public void insertData(Employee e, List<BankAcc> bankAcc) {
		et.begin();
		em.persist(e);
		for (BankAcc b : bankAcc)
			em.persist(b);
		et.commit();
	}
	public void update(int id,String name,int age,String bankType) {
		et.begin();
		Employee e1=em.find(Employee.class, id);
		BankAcc b1=em.find(BankAcc.class, id);
		e1.setAge(age);
		e1.setEmpName(name);
		b1.setAccType(bankType);
		em.merge(e1);
		em.merge(b1);
		et.commit();
	}
}
