package com.springbootjava.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	/*
	 * Get All Departments
	 */
	public List<Department> getAllDepartments() {
	    List<Department> departments = departmentRepository.findAll();
	    departments.forEach((d)->{
	    	System.out.println(d.getName());
	    });
	 return departments;	  

	}
	/*
	public List<Department> getEmployeesByDepartment(Long id, String expand) {
        List<Department> department = departmentRepository.findByIdWithEmployees(id);

		if ("employee".equals(expand)) {
            for(Department dept :department) {
                List<Employee> employee = employeeRepository.findEmployeeByDeptId(id);

            	dept.getDepartmentId();
            	dept.getName();
            	dept.getCreatedDate();
            	
             
            for(Employee emp :employee) {
            	emp.getName();
            	emp.getRole();
            	emp.getSalary();
            	employee.add(emp);
            	dept.addEmployee(emp);
            }
        	department.add(dept);
            }
           
	}
		return department;
		
		
	}	
	*/
}