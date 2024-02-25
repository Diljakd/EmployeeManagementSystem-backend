package com.springbootjava.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjava.model.Department;
import com.springbootjava.model.Employee;
import com.springbootjava.service.DepartmentService;
@RestController
@RequestMapping("/api/v2/")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
		
	//Add Department Rest Api
	@PostMapping("/add/departments")
	public Department addDepartment(@RequestBody Department department) {
		 return departmentService.addDepartment(department);
	}
	
	//update Department REST API
		@PutMapping("/update/departments/{id}")
		    public String updateDepartment(@PathVariable Long id, @RequestBody Department department) {
			departmentService.updateDepartment(id, department);
				return "success";
		    }
	//delete Department REST API
	@DeleteMapping("/delete/departments/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		return departmentService.deleteDepartment(id);
	}
	
	//GET All Departments REST API
		@GetMapping("/fetch/departments")
	    public List<Department> getAllDepartments() {
	        return departmentService.getAllDepartments();
	    }
		
		/*
	//Expand Employees under Departments
		 @GetMapping("/departments/{id}")
		  public List<Department> getEmployeesByDepartment(@PathVariable Long id, @RequestParam(required = false) String expand) {
		      return departmentService.getEmployeesByDepartment(id,expand);	
		 }
    */
		
}