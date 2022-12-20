package com.api.emp.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.emp.entities.Employee;
import com.api.emp.services.EmpService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmpService employeeService;
		
																																																																																																																																																																																																																																																																					
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeService.getAllEmployees();

}
	
	
	@GetMapping("/employees/age")
	public List<Employee> getEmployeeByAge(){
		return employeeService.findAllOrderByAge();
	}
	
	
	@GetMapping("/employees/firstName")
	public List<Employee> getEmployeeByName(){
		return employeeService.findAllOrderByName();
		
	}
	

	
//	@GetMapping("/employees/sort/{field}")
//	public List<Employee> sortEmployees(@PathVariable String field) {
//		return employeeService.sortEmployees(field);
//	}
	
	/*@GetMapping("/employees/{empId}")
	public Optional<Employee> getEmployee(@PathVariable("empId") Long empId) {
               return employeeService.getEmployeeById(empId);
	}*/
	
	@PostMapping("/employees")
	public Employee AddEmployee(@RequestBody Employee emp) {
		Employee e = this.employeeService.addEmployee(emp);
		System.out.println(emp);
		return e;
	}
	
	@PutMapping("/employees/{empId}")
	public Employee UpdateEmployee(@RequestBody Employee emp, @PathVariable("empId") Long empId) {
		this.employeeService.updateEmployee(emp, empId);
		return emp;
		
	}
	
	@DeleteMapping("/employees/{empId}")
	public void DeleteEmployee(@PathVariable("empId") Long empId) {
		this.employeeService.deleteEmployee(empId);
	}
	
}
