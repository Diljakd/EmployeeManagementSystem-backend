package com.springbootjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootjava.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
