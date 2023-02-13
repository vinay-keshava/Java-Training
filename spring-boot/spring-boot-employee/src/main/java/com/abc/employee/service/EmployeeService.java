package com.abc.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.abc.employee.model.Employee;

public interface EmployeeService {

	Employee insertEmployee(Employee e1);
	List<Employee> findAllEmp();
	Optional<Employee> retreiveById(int id);
	Employee updateEmployee(Employee e1,int id);
	void deleteEmp(int id);
	long countEmp();
	boolean EmpExits(int id);
	Page<Employee> retreiveOnlyFirstTwoEmp(int start,int end);
	List<Employee> sortByFirstName();
	
	
}
