package com.springbootjava.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjava.model.Department;
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
}
