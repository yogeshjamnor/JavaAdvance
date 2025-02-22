package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private int id;
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Column(name = "name", nullable = false)
    private String name;

    public Employee() {
    }

    public Employee(int id,String email, String name) {
        this.email = email;
        this.id=id;
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

    @Override
    public String toString() {
        return "Employee [id=" + id + ", email=" + email + ", name=" + name + "]";
    }
}
