package com.springbootjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjava.model.Employee;
import com.springbootjava.repository.EmployeeRepository;
@Service
public class  EmployeeService  {
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee) {
		employeeRepository.save(employee);
		//return "success";
		return employee;
	}

} 