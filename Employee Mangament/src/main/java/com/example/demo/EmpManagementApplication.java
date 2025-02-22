package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class EmpManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmpManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String url = "jdbc:mysql://localhost:3306/springboot?useSSL=false&serverTimezone=UTC";
        String user = "root"; 
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Database Connection Successful!");
            }
        } catch (Exception e) {
            System.err.println("❌ Database Connection Failed: " + e.getMessage());
        }
    }
}
