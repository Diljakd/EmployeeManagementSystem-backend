package com.springbootjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjava.model.Department;
import com.springbootjava.repository.DepartmentRepository;
@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}

}
