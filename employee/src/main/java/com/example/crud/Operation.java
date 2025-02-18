package com.example.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.example.empdetail.Employee;

@RestController
@RequestMapping("/emp")
public class Operation {

    private Map<Long, Employee> emp = new HashMap<>();

    // Adding some default employee entries
    public Operation() {
        // Adding some default employees when the application starts
        emp.put(1L, new Employee(1, "ABC", 30, "Male", "Engineering", 75000.0, "abc@example.com"));
        emp.put(2L, new Employee(2, "Xyz", 28, "Female", "Marketing", 65000.0, "xyz@example.com"));
        emp.put(3L, new Employee(3, "RDJ", 35, "Male", "Finance", 85000.0, "rdj@example.com"));
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAll() {
        return new ArrayList<>(emp.values());
    }

 // Create a new employee entry
    @PostMapping
    public void createEntry(@RequestBody Employee employee) {
        emp.put((long) employee.getEmployeeId(), employee);
    }

    // Retrieve an employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return emp.get(id);
    }

    // Update an employee by ID
    @PutMapping("/{id}")
    public void updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
        emp.put(id, employee);
    }

    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        emp.remove(id);
    }
}
