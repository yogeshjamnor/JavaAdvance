package com.example.demo.controller;

import com.example.demo.employee.Employee;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000") 
public class EmpController {

    @Autowired
    private EmpService empService;

    // Show Employee List (UI)
    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", empService.getAllEmployees());
        return "employeeList";
    }

    // Show Employee Registration Form (UI)
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    // Save Employee (UI)
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        empService.saveEmployee(employee);
        return "redirect:/employee";
    }

    // Show Update Form (UI)
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", empService.getEmployeeById(id));
        return "update";
    }


    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        empService.updateEmployee(employee);
        return "redirect:/employee";
    }

    // Delete Employee (UI)
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        empService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    // API: Get All Employees (JSON)
    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getAllEmployeesAPI() {
        return ResponseEntity.ok(empService.getAllEmployees());
    }

  
    @GetMapping("/emp/{id}")
    public ResponseEntity<?> getEmployeeByIdAPI(@PathVariable Integer id) {
        Employee employee = empService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.status(404).body(Map.of("error", "Employee not found"));
    }

    // Console Code for Employee Management
    @PostMapping("/emp/save")
    public ResponseEntity<Map<String, String>> saveEmployeeAPI(@RequestBody Employee employee) {
        empService.saveEmployee(employee);
        return ResponseEntity.ok(Map.of("message", "Employee saved successfully"));
    }

    // API: Update Employee
    @PutMapping("/emp/update")
    public ResponseEntity<Map<String, String>> updateEmployeeAPI(@RequestBody Employee employee) {
        empService.updateEmployee(employee);
        return ResponseEntity.ok(Map.of("message", "Employee updated successfully"));
    }

    // API: Delete Employee
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<Map<String, String>> deleteEmployeeAPI(@PathVariable Integer id) {
        empService.deleteEmployeeById(id);
        return ResponseEntity.ok(Map.of("message", "Employee deleted successfully"));
    }
}
