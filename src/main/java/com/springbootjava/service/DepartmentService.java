package com.springbootjava.service;

import java.util.List;

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
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Department addDepartment(Department department) {
		departmentRepository.save(department);
		return department;
	}
	 public void updateDepartment(Long id, Department department) {
		 departmentRepository.updateDepartmentDetails(id,department.getName(),department.getCreatedDate(),department.getEmployee().getEmployeeId());
	 }
	public String deleteDepartment(Long id) {
		String message="";
		
		List<Employee> list=employeeRepository.findEmployeeByDeptId(id);
		if(!list.isEmpty()) {
	    	message ="Failed Deletion due to Employees are Assigned to the  Department";
	 	}
	    else {
	 		departmentRepository.deleteDepartmentDetails(id);
	 		message ="Deleted successfully";
	 	}
			return message;

	}	  

	}	