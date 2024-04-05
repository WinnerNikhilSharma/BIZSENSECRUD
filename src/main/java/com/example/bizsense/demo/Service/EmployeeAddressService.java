package com.example.bizsense.demo.Service;

@Service
public class EmployeeAddressService {
	@Autowired
	private EmployeeAddressRepository employeeAddressRepository;

	public EmployeeAddress createEmployeeAddress(EmployeeAddress address) {
		if (address.getStreet() == null || address.getStreet().isEmpty()) {
			throw new IllegalArgumentException("Street name cannot be empty");
		}
		return employeeAddressRepository.save(address);
	}
}
