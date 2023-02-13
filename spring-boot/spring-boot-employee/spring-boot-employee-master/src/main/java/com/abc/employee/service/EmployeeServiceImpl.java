package com.abc.employee.service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.abc.employee.model.Employee;
import com.abc.employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	PagingAndSortingRepository<Employee, Integer> pageSortRepo;

	@Override
	public Employee insertEmployee(Employee e1) {
		return empRepo.save(e1);
	}

	@Override
	public List<Employee> findAllEmp() {
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> retreiveById(int id) {
		return empRepo.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee e1, int id) {
		Employee e2 = empRepo.findById(id).get();
		e2.setFirstName(e1.getFirstName());
		e2.setAge(e1.getAge());
		e2.setUsername(e1.getUsername());
		e2.setPassword(e1.getPassword());
		return empRepo.save(e2);
	}

	@Override
	public void deleteEmp(int id) {
		Employee ed = empRepo.findById(id).get();
		empRepo.delete(ed);
	}

	@Override
	public long countEmp() {
		return empRepo.count();
	}

	@Override
	public boolean EmpExits(int id) {
		return empRepo.existsById(id);
	}
	
	@Override
	public Page<Employee> retreiveOnlyFirstTwoEmp(int end, int start) {
		Page<Employee> emp = pageSortRepo.findAll(PageRequest.of(start, end));
		return emp;
	}

	@Override
	public List<Employee> sortByFirstName() {
//		Sort nameSort=Sort.by("FirstName");
//		List<Employee> emp = (List<Employee>) empRepo.findAll(Sort.by("FirstName"));
//		return emp;
		return empRepo.findAll(Sort.by("firstName"));
	}

	public List<Employee> findByFirstName(String f_name) {
		return empRepo.findByFirstName(f_name);
	}

	public List<Employee> findByFirstNameContains(String f_name) {
		return empRepo.findByFirstNameContains(f_name);
	}

	public List<Employee> allOrderById() {
		return empRepo.findAllByOrderByIdDesc();
	}

//	public List<Employee> fnameAndAge(int age, String f_name) {
//		return empRepo.findByFirstNameAndAge(f_name, age);
//	}

	public List<Employee> fnameOrAge(int age, String f_name) {
		return empRepo.findByFirstNameOrAge(f_name, age);
	}

	public List<Employee> AgeBetween(int a1, int a2) {
		return empRepo.findByAgeBetween(a1, a2);
	}

	public List<Employee> salariesLessThan(int lowLimitSal) {
		return empRepo.findBySalaryLessThan(lowLimitSal);
	}

	public List<Employee> salariesLessThanAndEqualTo(int salLimit) {
		return empRepo.findBySalaryLessThanEqual(salLimit);
	}

	public List<Employee> salariesLessThanAndEqualOrderByFirstName(int salLimit) {
		return empRepo.findBySalaryLessThanEqualOrderByFirstName(salLimit);
	}

	public List<Employee> findBySalaryOrderByAgeofEmp(int age) {
		return empRepo.findBySalaryOrderByAge(age);
	}

	public List<Employee> firstNameMatching(String user_name) {
		return empRepo.findByusernameLike(user_name);
	}

	public List<Employee> NameStartingWith(String name) {
		return empRepo.findByFirstNameStartingWith(name);
	}
	public List<Employee> NameEndingWith(String name) {
		return empRepo.findByFirstNameEndingWith(name);
	}
	public List<Employee> firstNameContaining(String fname){
		return empRepo.findByFirstNameContains(fname);
	}
	public List<Employee> findByAgeIn(Collection<Employee> a){
		return empRepo.findByAgeIn(a);
	}
	public List<Employee> JoinedBetweenTwoDates(Date d1,Date d2){
		return empRepo.findByJoinedDateBetween(d1, d2);
	}
	public List<Employee> isNullJoiningDate() {
		return empRepo.findByJoinedDateIsNull();
	}
	public List<Employee> allEmployee(){
		return empRepo.findAllEmployee();
	}
	public int calcSumSal() {
		return empRepo.calulateSum();
	}
	
	public int maxSal() {
		return empRepo.maxSalary();
	}
	public int minSal() {
		return empRepo.minSalary();
	}
	public List<Employee> nameWithVirat(){
		return empRepo.nameWithVir();
	}

	public Employee maxSalaryDetailsEMP() {
		return empRepo.maxSalaryPersonDetails();
	}

}
