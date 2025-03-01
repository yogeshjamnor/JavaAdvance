package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "hotels")
public class Hotel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Integer id;

    @NotBlank(message = "Hotel name is required")
    @Size(min = 3, max = 100, message = "Hotel name should be between 3 and 100 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Location is required")
    @Column(name = "location", nullable = false)
    private String location;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    @Column(name = "rating")
    private int rating;

    // Default constructor (needed by JPA)
    public Hotel() {}

    // Parameterized constructor
    public Hotel(String name, String location, int rating) {
        this.name = name;
        this.location = location;
        this.rating = rating;
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
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }

    // toString() for debugging and logging
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating + "]";
    }
}
