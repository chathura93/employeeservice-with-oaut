package com.ishan.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ishan.employeeservice.Repository.EmployeeRepository;
import com.ishan.employeeservice.modal.Allocation;
import com.ishan.employeeservice.modal.Employee;
import com.ishan.employeeservice.modal.Telephone;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		for (Telephone telephone : employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		return employeeRepository.save(employee);
	}

	public List<Employee> fetchAllEmployees() {
		return employeeRepository.findAll();

	}

	public Employee fetchEmployee(Employee employee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

		if (optionalEmployee.isPresent()) {
			HttpHeaders headers = new HttpHeaders();
			RestTemplate restTemplate = new RestTemplate();
			OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext()
					.getAuthentication().getDetails();
			headers.add("Authorization", "bearer ".concat(details.getTokenValue()));

			ResponseEntity<Allocation[]> responseEntity;
			HttpEntity<String> entity = new HttpEntity<>("", headers);

			responseEntity = restTemplate.exchange(
					"http://localhost:9090/emscloud/allocation/".concat(employee.getId().toString()), HttpMethod.GET,
					entity, Allocation[].class);
			
			Employee employee1 = optionalEmployee.get();
			System.out.println(responseEntity.getBody().toString());
			employee1.setAllocations(responseEntity.getBody());

			return optionalEmployee.get();
		} else {
			return null;
		}
	}
}
