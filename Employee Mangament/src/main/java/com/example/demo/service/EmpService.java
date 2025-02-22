package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpService
{
	@Autowired
	private EmpRepository empRepo;
	
	public List<Employee>getAllEmployee(){
		return empRepo.findAll();
	}
	
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return empRepo.save(employee);
	}
	
	public Employee getEmployeebyId(Integer id) {
		return empRepo.findById(id).orElse(null);
	}
	public boolean deleteEmployeebyId(Integer id) {
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
			
	}
}
