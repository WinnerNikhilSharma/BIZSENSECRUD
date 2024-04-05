package com.example.bizsense.demo.Controller;

@Restcontroller
@Requestmapping("/api/employees") // this end point we can customize it as per requirement
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceES;

	@PostMapping // NEW
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee) {
		Employee createdEmployee = employeeServiceES.createEmployee(employee);
		return new responseentity<>(createdEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}") // UPDATE
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
			@RequestBody @Valid Employee updatedEmployee) {
		Employee employee = employeeService.updateEmployee(id, updatedEmployee);
		return responseentity.ok(employee);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String keyword) {
		List<Employee> employees = employeeService.getAllEmployeesSortedAndFiltered(keyword);
		return ResponseEntity.ok(employees);
	}
}