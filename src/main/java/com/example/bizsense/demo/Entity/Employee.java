package com.example.bizsense.demo.Entity;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String email;
    private String phone;
    // Either LOMBOK annotations like data OR specify getters/ setters
}

