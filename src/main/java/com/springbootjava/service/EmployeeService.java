package com.springbootjava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjava.model.Department;
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
	 /*
	  * Update Employees Department
	  */
	public void updateEmployeeDepartment(Long id, Employee employee) {
    employeeRepository.updateEmployeeDepartmentDetails(id, employee.getDepartment().getDepartmentId());		
	}
	/*
	 * Get All Employees
	 */
	public List<Employee> getAllEmployees() {
	    List<Employee> employees = employeeRepository.findAll();
	    employees.forEach((e)->{
	    	System.out.println(e.getName());
	    });
	 return employees;
	       
}
}