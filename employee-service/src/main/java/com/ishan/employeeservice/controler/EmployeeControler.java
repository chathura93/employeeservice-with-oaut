package com.ishan.employeeservice.controler;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ishan.employeeservice.modal.Address;
import com.ishan.employeeservice.modal.Employee;
import com.ishan.employeeservice.modal.Project;
import com.ishan.employeeservice.service.EmployeeService;

@RestController
@RequestMapping(value = "/emscloud")
public class EmployeeControler {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@RequestMapping(value = "/employee",method = RequestMethod.GET)
	public List<Employee> fetchAllEmployee(){
		return employeeService.fetchAllEmployees();
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> fetchEmployee(@PathVariable Integer id) {
		Employee employee = new Employee();
		employee.setId(id);
		Employee employee1 = employeeService.fetchEmployee(employee);
		if (employee1 == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(employee1);
		}
	}
	@RequestMapping(value = "/employee/{id}/projects", method = RequestMethod.GET)
	public ResponseEntity<List<Project>>
		fetchEmployeeProjects(@PathVariable Integer id){
			Employee employee= new Employee();
			employee.setId(id);
		Employee employee2	= employeeService.fetchEmployee(employee);
			if (employee2 == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(employee2.getProjects());
			}
		}

	@RequestMapping(value = "/test")
	public Employee test() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Ishan Chathura");
		Address address =new Address();
		address.setAddress1("Matara");
		address.setCity("colombo");
		return employee;
		
		
	}
	@RequestMapping(value = "/test2")
	public ResponseEntity<Employee> test1() {
		Integer x = 10;
		if(x==null) {
			Employee employee = new Employee();
			employee.setId(1);
			employee.setName("Ishan");
			Address address =new Address();
			address.setAddress1("Matara");
			address.setCity("colombo");
			return ResponseEntity.ok(employee);
			
		}else {
			
			HttpHeaders httpheader=new HttpHeaders();
			httpheader.add("status", "invalid-status");
			return ResponseEntity.notFound().headers(httpheader).build();
		}
		
		
		
	}
	
}
