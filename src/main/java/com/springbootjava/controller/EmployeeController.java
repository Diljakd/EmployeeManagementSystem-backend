package com.springbootjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjava.model.Employee;
import com.springbootjava.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	//Create Employee REST API
	@PostMapping("/create/employees")
   public Employee createEmployees(@RequestBody Employee employee) {
	   return employeeService.createEmployee(employee);
	   
   }
	//update Employee REST API
	@PutMapping("/update/employees/{id}")
	    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		   employeeService.updateEmployee(id, employee);
			return "success";
	    }
	
	//Update Employee's Department REST API
	@PutMapping("/update/employees/department/{id}")
	public String updateEmployeeDepartment(@PathVariable Long id, @RequestBody Employee employee) {
		   employeeService.updateEmployeeDepartment(id, employee);
		return " Employees Department updated Successfully";
		
	}
	//GET All Employees REST API
	@GetMapping("/fetch/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}