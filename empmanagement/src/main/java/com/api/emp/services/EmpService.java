package com.api.emp.services;


import java.util.List;

//import java.util.Optional;
import com.api.emp.entities.Employee;


public interface EmpService {
	
	 public List<Employee> getAllEmployees();
	 
	// public Optional<Employee> getEmployeeById(Long empid);
	 
	 public List<Employee> sortEmployees(String field);
	 
	 public Employee addEmployee(Employee emp);
	 
	 public void updateEmployee(Employee emp, Long empId);
	 
	 public void deleteEmployee(Long empId);
	 
	 public List<Employee> findAllOrderByName();
	 
	public List<Employee> findAllOrderByAge();
	

	
	

}
