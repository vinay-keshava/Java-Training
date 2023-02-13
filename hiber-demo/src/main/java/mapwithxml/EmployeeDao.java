package mapwithxml;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmployeeDao {

	StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
	SessionFactory factory = metadata.getSessionFactoryBuilder().build();

	Transaction transaction = null;

	public void saveEmployee(Employee employee) {

		Session session = factory.openSession();
		try {
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<Employee> getEmployeeDetails() {

		List<Employee> employees = new ArrayList<>();
		Session session = factory.openSession();
		try {
			transaction = session.beginTransaction();
			employees = session.createQuery("From Employee").list();
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
		return employees;

	}

	public void updateEmployee(int id, String empName, String empEmail) {

		Session session = factory.openSession();
		try {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			employee.setFirstName(empName);
			employee.setLastName(empEmail);
			session.update(employee);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteEmployeeById(int id) {
		Session session = factory.openSession();
		try {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			session.delete(employee);
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}
}