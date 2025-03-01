package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepo studentRepo;

    // Get all students for UI display
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    // Save Student with UI-friendly response
    public String saveStudent(Student student) {
        if (studentRepo.existsById(student.getId())) {
            return "Student ID already exists!";
        }
        studentRepo.save(student);
        return "Student successfully added!";
    }

    // Update Student details
    public String updateStudent(Student student) {
        if (!studentRepo.existsById(student.getId())) {
            return "Student not found!";
        }
        studentRepo.save(student);
        return "Student details updated successfully!";
    }

    // Fetch Student by ID
    public Student getStudentById(Integer id) {
        Optional<Student> student = studentRepo.findById(id);
        return student.orElse(null);
    }

    // Delete Student and return a UI-friendly message
    public String deleteStudentById(Integer id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return "Student deleted successfully!";
        }
        return "Student ID not found!";
    }
}