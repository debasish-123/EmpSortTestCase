package com.api.emp.services;

import java.util.Collections;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.emp.Repository.EmpRepository;
import com.api.emp.entities.Employee;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository employeeRepository;
	
	
	    @Override
        public List<Employee> getAllEmployees(){
		List<Employee> list = (List<Employee>) this.employeeRepository.findAll();
		System.out.println("Get all employees"+list);
		return list;
	   }
		
		@Override
	    public List<Employee> sortEmployees(String field) {
			return employeeRepository.findAll(Sort.by(field));
		}
	 /*   @Override
        public Optional<Employee> getEmployeeById(Long empid) {
        	Optional<Employee> emp = null;
        	try {
    			emp = this.employeeRepository.findById(empid);
    			
    		}catch (Exception e) {
    			e.printStackTrace();
    			
    		}
    		return emp;
       		
       		
       	}
       	*/
		
		
		
		@Override
		public List<Employee> findAllOrderByName(){
			List<Employee> emp1 = (List<Employee>) findAll();
			int list1=emp1.size();
			for(int i=0;i<list1;i++) {
				for(int j=i+1;j<list1;j++) {
					String a=emp1.get(i).getFirstName()+" "+emp1.get(i).getLastName();
					String b=emp1.get(j).getFirstName()+" "+emp1.get(j).getLastName();
					if(a.compareTo(b) > 0) {
						Collections.swap(emp1, i, j);
					}
				}
			}
			return emp1;
		}
		
		
		private List<Employee> findAll() {
			
			return (List<Employee>) employeeRepository.findAll();
		}
	    
		
		@Override
		public List<Employee> findAllOrderByAge(){
			List<Employee> emp2=(List<Employee>) findAll();
			int list=emp2.size();
			for(int i=0;i<list;i++) {
				for(int j=i+1;j<list;j++) {
					if(emp2.get(i).getAge()>emp2.get(j).getAge()) {
						Collections.swap(emp2, i, j);
					}
				}
			}
			return emp2;
		}
	    
	@Override
	public Employee addEmployee(Employee emp) {
			Employee newEmp = this.employeeRepository.save(emp);
			return newEmp;
	}
	
	@Override
	public void updateEmployee(Employee emp, Long empId) {
		emp.setEmpId(empId);
		employeeRepository.save(emp);
		
		
	}
	
	
	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}

}
