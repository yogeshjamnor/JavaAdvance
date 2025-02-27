package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.repository.EmpRepo;

@Service
public class EmpService {
    
    @Autowired
    private EmpRepo empRepo;

    // Get all employees for UI display
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    // Save Employee with UI-friendly response
    public String saveEmployee(Employee employee) {
        if (empRepo.existsById(employee.getId())) {
            return "Employee ID already exists!";
        }
        empRepo.save(employee);
        return "Employee successfully added!";
    }

    // Update Employee details
    public String updateEmployee(Employee employee) {
        if (!empRepo.existsById(employee.getId())) {
            return "Employee not found!";
        }
        empRepo.save(employee);
        return "Employee details updated successfully!";
    }

    // Fetch Employee by ID
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = empRepo.findById(id);
        return employee.orElse(null);
    }

    // Delete Employee and return a UI-friendly message
    public String deleteEmployeeById(Integer id) {
        if (empRepo.existsById(id)) {
            empRepo.deleteById(id);
            return "Employee deleted successfully!";
        }
        return "Employee ID not found!";
    }
}
