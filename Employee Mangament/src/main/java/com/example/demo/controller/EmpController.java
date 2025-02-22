package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmpController {

    @Autowired
    private EmpService empserv;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployee() {
        return empserv.getAllEmployee();
    }

    // Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return empserv.saveEmployee(employee);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee existEmp = empserv.getEmployeebyId(id);

        if (existEmp != null) {
            existEmp.setName(employee.getName());
            existEmp.setEmail(employee.getEmail());

            Employee updatedEmp = empserv.updateEmployee(existEmp);
            return ResponseEntity.ok(updatedEmp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        boolean deleted = empserv.deleteEmployeebyId(id);

        if (deleted) {
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
