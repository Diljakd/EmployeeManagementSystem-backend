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
	 public void updateEmployee(Long id, Employee employee) {
		  employeeRepository.updateEmployeeDetails(id,employee.getName(),employee.getAddress(),employee.getJoiningDate(),
				  employee.getDateOfBirth(),employee.getRole(),employee.getSalary(),employee.getYearlyBonusPercentage(),
				  employee.getDepartment().getDepartmentId(),employee.getReportingManager().getEmployeeId());
	 }	     
	       
}