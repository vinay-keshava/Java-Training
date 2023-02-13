package com.abc.employee.repository;

import org.springframework.stereotype.Repository;

import com.abc.employee.model.Employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstName(String f_name);

	// Creating a query for this
	List<Employee> findByFirstNameContains(String f_name);

	List<Employee> findAllByOrderByIdDesc();

//	List<Employee> findByFirstNameAndAge(String f_name, int age);

	List<Employee> findByFirstNameOrAge(String f_name, int age);

	List<Employee> findByAgeBetween(int a1, int a2);

	List<Employee> findBySalaryLessThan(int lowLimit);

	List<Employee> findBySalaryLessThanEqual(int salLimit);

	List<Employee> findBySalaryLessThanEqualOrderByFirstName(int salLimit);
//	List<Employee> findByAgeOrderByFirstNameAndUserName(int age);


	// Sorting the salaries having less than the specified limit and sorting the
	// output
	List<Employee> findBySalaryOrderByAge(int age); // finding the same age people and ordering them based on age (:

	// boolean findByFirstName(String f_name);// Search Employee ->true of false
	// comment out the List<Employee> findByFirstName(String f_name); for this to
	// work

	// username like
	List<Employee> findByusernameLike(String username);

	List<Employee> findByFirstNameStartingWith(String firstName);

	List<Employee> findByFirstNameEndingWith(String firstName);

	List<Employee> findByFirstNameContaining(String firstName);

	List<Employee> findByAgeIn(Collection<Employee> a);

	List<Employee> findByJoinedDateBetween(Date d1, Date d2);

	List<Employee> findByJoinedDateIsNull();

	@Query("Select e from Employee e")
	List<Employee> findAllEmployee();

	// Sum of salaries of all employee;
	@Query("Select sum(salary) from Employee e")
	int calulateSum();
	
	@Query("Select max(salary) from Employee e")
	int maxSalary();
	
	@Query("Select min(salary) from Employee ")
	int minSalary();
	
	@Query("Select e from Employee e where first_name like 'V%'")
	List<Employee> nameWithVir();
	
	@Query("select e from Employee e where salary=(select max(salary) from Employee )")
	Employee maxSalaryPersonDetails();

}
