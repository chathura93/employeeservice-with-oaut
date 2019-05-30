package com.ishan.employeeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ishan.employeeservice.modal.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
