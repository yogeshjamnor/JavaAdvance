package com.example.demo.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int id;

    @Email(message = "Invalid email format") // Ensures a valid email format
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    @NotBlank(message = "Name is required") // Prevents empty name
    @Column(name = "name", nullable = false)
    private String name;

    // Default constructor (needed by JPA)
    public Employee() {}

    // Parameterized constructor
    public Employee(String email, String name) {
        this.email = email;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // toString() for debugging and logging
    @Override
    public String toString() {
        return "Employee [id=" + id + ", email=" + email + ", name=" + name + "]";
    }
}
