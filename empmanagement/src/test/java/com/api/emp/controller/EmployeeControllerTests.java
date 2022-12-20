package com.api.emp.controller;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import com.api.emp.Repository.EmpRepository;
import com.api.emp.entities.Employee;
import com.api.emp.services.EmpServiceImpl;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {
	
	
	@InjectMocks
	private EmpServiceImpl empService;
	
	List<Employee> empList=new ArrayList<Employee>();
	List<Employee> empList1=new ArrayList<Employee>();
	
	@Mock
	private EmpRepository empRepository;
	
	@Test
	public void getEmployeesTest() {
		
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(982, "Hello", "World", 40, 10000));
		emp.add(new Employee(983, "Ankit", "Kumar", 50, 20000));
		emp.add(new Employee(984, "Asutosh", "Satpathy", 50, 45000));
		emp.add(new Employee(985, "Suhana", "Triapthy", 50, 40000));
		
		when(empService.getAllEmployees()).thenReturn(emp);
		List<Employee> emp2 = empService.getAllEmployees();

		assertThat(emp2).isNotNull();
		assertThat(emp2.size()).isEqualTo(4);
	}
	
	@Test
	public void AddEmployeeTest(){
		
		
		Employee emp= new Employee(987,"Hello","World",40,7650);
		when(empRepository.save(emp)).thenReturn(emp);
		
		Employee newEmp = empService.addEmployee(emp);
		System.out.println(newEmp);
		assertThat(newEmp).isNotNull();
	}
	
	
	
	 @Test
	 public void UpdateEmployeeTest() {
	    	Employee emp= new Employee(985,"Ram","Satpathy",40,10000);
	    	when(empRepository.save(emp)).thenReturn(emp);
	    	emp.setAge(50);
	    	emp.setFirstName("Anmol");
	    	emp.setLastName("Sharma");
	    	emp.setSalary(20000);
	    	
	    	Employee newEmployee=empService.addEmployee(emp);
	    	
	    	assertThat(newEmployee.getAge()).isEqualTo(50);
	    	assertThat(newEmployee.getFirstName()).isEqualTo("Anmol");
	    	assertThat(newEmployee.getLastName()).isEqualTo("Sharma");
	    	assertThat(newEmployee.getSalary()).isEqualTo(20000);
	    }
	 
	    @Test
	    public void DeleteEmployeeTest() {
	    	long empid=985;
	    	willDoNothing().given(empRepository).deleteById(empid);
	    	empService.deleteEmployee(empid);
	    	verify(empRepository, times(1)).deleteById(empid);
  }

	    
//	    @Test
//	    public void sortEmployees() {
//	    	Employee employee= new Employee(986,"Jai","Hind",46,345);
//	    	Employee employee1=new Employee(987,"Kumar","Ankit",12,678);
//	    	Employee employee3=new Employee(988,"Vishal","Kumar",76,542);
//	    	listemp.add(employee);
//	    	listemp.add(employee1);
//	    	listemp.add(employee3);
//	    	Mockito.when(empRepository.findAll()).thenReturn(listemp);
//	    	listemp1=empService.sortEmployees("age");
//	    	assertEquals(11,listemp1.get(0).getAge()); 
//	    }
	    
	    @Test
		public void findAllOrderByAge() {
			Employee emp= new Employee(120,"Abhishek ","Singh",40,7650);
			Employee emp1=new Employee(150,"Ankit","Kumar",24,5600);
			
			
			
			empList.add(emp);
			empList.add(emp1);
			
			Mockito.when(empRepository.findAll()).thenReturn(empList);
			empList1=empService.findAllOrderByAge();
			assertEquals(24,empList1.get(0).getAge()); 
		}
	
		@Test
		public void findAllOrderByName() {
			Employee emp= new Employee(200,"Roopa","Rajeshwari",30,7650);
			Employee emp1=new Employee(240,"Ankit","Kumar",20,8790);
			Employee emp2=new Employee(260,"Roshan","Kumar",25,5780);
			Employee emp3=new Employee(280,"Ankit","Kumar",28,2608);
			empList.add(emp);
			empList.add(emp1);
			empList.add(emp2);
			Mockito.when(empRepository.findAll()).thenReturn(empList);
			empList1=empService.findAllOrderByName();
			assertEquals("Ankit Kumar", empList1.get(0).getFirstName()+" "+empList1.get(0).getLastName());
			
		}

}



