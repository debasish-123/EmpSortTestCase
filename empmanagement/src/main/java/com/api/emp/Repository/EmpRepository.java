package com.api.emp.Repository;


//import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.api.emp.entities.Employee;

@Service
public interface EmpRepository extends JpaRepository<Employee, Long> {
	
//	@Query("Select * From Employee ORDER BY firstName ASC")
//	List<Employee> getEmployees(Sort sort);


}
