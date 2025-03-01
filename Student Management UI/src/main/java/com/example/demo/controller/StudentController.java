package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000") 
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show Student List (UI)
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "studentList";
    }

    // Show Student Registration Form (UI)
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    // Save Student (UI)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    // Show Update Form (UI)
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "update";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    // Delete Student (UI)
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }

    // API: Get All Students (JSON)
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudentsAPI() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentByIdAPI(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.status(404).body(Map.of("error", "Student not found"));
    }

    // API: Save Student
    @PostMapping("/students/save")
    public ResponseEntity<Map<String, String>> saveStudentAPI(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok(Map.of("message", "Student saved successfully"));
    }

    // API: Update Student
    @PutMapping("/students/update")
    public ResponseEntity<Map<String, String>> updateStudentAPI(@RequestBody Student student) {
        studentService.updateStudent(student);
        return ResponseEntity.ok(Map.of("message", "Student updated successfully"));
    }

    // API: Delete Student
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, String>> deleteStudentAPI(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok(Map.of("message", "Student deleted successfully"));
    }
}