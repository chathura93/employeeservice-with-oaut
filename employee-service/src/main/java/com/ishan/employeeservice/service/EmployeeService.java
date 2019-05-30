package com.ishan.employeeservice.service;

import java.util.List;

import com.ishan.employeeservice.modal.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	List<Employee> fetchAllEmployees();
	Employee fetchEmployee(Employee employee);

} 