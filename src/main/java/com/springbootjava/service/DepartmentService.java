package com.springbootjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjava.model.Department;
import com.springbootjava.model.Employee;
import com.springbootjava.repository.DepartmentRepository;
import com.springbootjava.repository.EmployeeRepository;
@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}
	 public void updateDepartment(Long id, Department department) {
		 departmentRepository.updateDepartmentDetails(id,department.getName(),department.getCreatedDate(),department.getEmployee().getEmployeeId());
	 }	  

}
