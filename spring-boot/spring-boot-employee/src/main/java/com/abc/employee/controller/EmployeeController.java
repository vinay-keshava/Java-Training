package com.abc.employee.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.employee.model.Employee;
import com.abc.employee.service.EmployeeServiceImpl;

import antlr.debug.MessageListener;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empSerImpl;

	// below are the endpoints
	@GetMapping("/AllEmp")
	public List<Employee> findAllEmployee() {
		return empSerImpl.findAllEmp();
	}

	@PostMapping("/insertEmp")
	public Employee insertEmp(Employee e2) {
		return empSerImpl.insertEmployee(e2);
	}

	@GetMapping("/{id}")
	public Optional<Employee> retById(@PathVariable("id") int id) {
		return empSerImpl.retreiveById(id);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmp(@PathVariable("id") int id, @RequestBody Employee e1) {

		return empSerImpl.updateEmployee(e1, id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable("id") int id) {
		empSerImpl.deleteEmp(id);
	}

	@GetMapping("/count")
	public long countEmployee() {
		return empSerImpl.countEmp();
	}

	@GetMapping("/existsEmp/{id}")
	public boolean existsEmployee(@PathVariable(value = "id") int id) {
		return empSerImpl.EmpExits(id);
	}

	@GetMapping("/pageSort/{start}/{end}")
	public Page<Employee> retreiveOnlyTwoEmp(@PathVariable(value = "start") int start,
			@PathVariable(value = "end") int end) {
		return empSerImpl.retreiveOnlyFirstTwoEmp(end, start);
	}

	@GetMapping("/sortByFirstName")
	public List<Employee> sortName() {
		return empSerImpl.sortByFirstName();
	}

	@GetMapping("/findByFirstName")
	public List<Employee> findByFirstName(@RequestParam String f_name) {
		return empSerImpl.findByFirstName(f_name);
	}

	@GetMapping("/contains/f_name")
	public List<Employee> findByFirstnameOrderByfirstName(@RequestParam String f_name) {
		return empSerImpl.findByFirstNameContains(f_name);
	}

	@GetMapping("/orderById")
	public List<Employee> OrderById() {
		return empSerImpl.allOrderById();
	}

	@GetMapping("/findByFnameAndAge")
	public List<Employee> retrieveBasedOnFnameAndAge(int age, String f_name) {
//		return empSerImpl.fnameAndAge(age, f_name);
		return empSerImpl.fnameOrAge(age, f_name);

	}

	@GetMapping("/ageBtw")
	public List<Employee> ageBetweenTwoLimits(int a1, int a2) {
		return empSerImpl.AgeBetween(a1, a2);
	}

	@GetMapping("/salLessThan")
	public List<Employee> salaryLessThan(int limit) {
		return empSerImpl.salariesLessThan(limit);
	}

	@GetMapping("/salLessThanEqual")
	public List<Employee> salaryLessThanEqualTO(int limit) {
		return empSerImpl.salariesLessThanAndEqualTo(limit);
	}

	@GetMapping("/salLessThanOrderByFirstName")
	public List<Employee> salaryLessThanOrderBy(int limit) {
		return empSerImpl.salariesLessThanAndEqualOrderByFirstName(limit);
	}

	// findBySalaryOrderByAge
	@GetMapping("/salOrderByAge")
	public List<Employee> salaryOrderByAge(int age) {
		return empSerImpl.findBySalaryOrderByAgeofEmp(age);
	}

	@GetMapping("/userNameLike")
	public List<Employee> userNameLike(String user_name) {
		return empSerImpl.firstNameMatching(user_name);
	}

	@GetMapping("/firstNameStartingWith")
	public List<Employee> NamestartingWithSpecifiedName(String name) {
		return empSerImpl.NameStartingWith(name);
	}

	@GetMapping("/firstNameEndingWith")
	public List<Employee> NameEndingWithSpecifiedName(String name) {
		return empSerImpl.NameEndingWith(name);
	}

	@GetMapping("/firstNameContaining")
	public List<Employee> firstNameContainsTheSequenceOfWords(String fname) {
		return empSerImpl.firstNameContaining(fname);
	}
//	Collection<Employee> a=new ArrayList<>();
//	@GetMapping("/in")
//	public List<Employee> inCollection(){
//		return empSerImpl.findByAgeIn();
//	}

	@GetMapping("/joinedDate")
	public List<Employee> joinedBetweenTwoDate(@RequestParam Date d1, @RequestParam Date d2) {
		return empSerImpl.JoinedBetweenTwoDates(d1, d2);
	}

	@GetMapping("/isNullJoiningDate")
	public List<Employee> isJoiningDateNull() {
		return empSerImpl.isNullJoiningDate();
	}

	@GetMapping("/allEmployee")
	public List<Employee> allEmpInCompany() {
		return empSerImpl.allEmployee();
	}

	@GetMapping("/salSum")
	public int calcSum() {
		return empSerImpl.calcSumSal();
	}

	@GetMapping("/maxSal")
	public int maxSalary() {
		return empSerImpl.maxSal();

	}
	@GetMapping("/minSal")
	public int minSalary() {
		return empSerImpl.minSal();
	}
	
	@GetMapping("/nameWithVir")
	public List<Employee> nameWithVirat(){
		return empSerImpl.nameWithVirat();
	}
//	@GetMapping("/findAgeByFnUn")
//	public List<Employee> findByAgeFnameLname(int age){
//		return empSerImpl.findbyAgeOrderFnameUserName(age);
//	}
	
	@GetMapping("/maxSalEmpDetails")
	public Employee maxSalaryEmp() {
		return empSerImpl.maxSalaryDetailsEMP();
	}
}
