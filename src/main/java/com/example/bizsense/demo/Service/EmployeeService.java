package com.example.bizsense.demo.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
    Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found”));
    existingEmployee.setName(updatedEmployee.getName());
    // Update ALL other fields in similar way
    return employeeRepository.save(existingEmployee);
}

	public Employee createEmployee(Employee employee) {
		if (employee.getName() == null || employee.getName().isEmpty()) {
			throw new IllegalArgumentException("Pls type name");
		}
	return employeeRepository.save(employee); // Saving the employee
	}

	public list<employee> getAllEmployees(String keyword) {
    Stream<Employee> employeeStream = employeeRepository.findAll().stream();

    if (keyword != null && !keyword.isEmpty()) {
        employeeStream = employeeStream.filter(employee -> employee.getName().contains(keyword));
    }
    return employeeStream.sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
	}
	
}
