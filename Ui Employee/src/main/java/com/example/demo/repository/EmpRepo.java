package com.example.demo.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.employee.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>
{
	
}
