package com.example.bizsense.demo.Controller;

@RestController
@RequestMapping("/api/employee-addresses")
public class EmployeeAddressController {
	@Autowired
	private EmployeeAddressService employeeAddressService;

	@PostMapping
	public ResponseEntity<EmployeeAddress> createEmployeeAddress(@RequestBody @Valid EmployeeAddress address) {
		EmployeeAddress createdAddress = employeeAddressService.createEmployeeAddress(address);
		return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
	}
}
