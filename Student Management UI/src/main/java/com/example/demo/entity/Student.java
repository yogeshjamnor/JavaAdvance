package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Integer id;

    @NotBlank(message = "Student name is required")
    @Size(min = 3, max = 100, message = "Student name should be between 3 and 100 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Department is required")
    @Column(name = "department", nullable = false)
    private String department;

    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 100, message = "Age must be at most 100")
    @Column(name = "age")
    private int age;

    // Default constructor (needed by JPA)
    public Student() {}

    // Parameterized constructor
    public Student(String name, String department, int age) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    // toString() for debugging and logging
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", department=" + department + ", age=" + age + "]";
    }
}