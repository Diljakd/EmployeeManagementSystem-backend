package com.springbootjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootjava.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{ 

}
