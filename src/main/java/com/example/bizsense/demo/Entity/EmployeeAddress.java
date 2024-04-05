package com.example.bizsense.demo.Entity;

@Entity
@Table(name = "employee_addresses")
public class EmployeeAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String street;
	private String city;
	// getters and setters implementation
}
