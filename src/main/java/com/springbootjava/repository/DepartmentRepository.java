package com.springbootjava.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootjava.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE department d SET d.name =:name, d.created_date =:createdDate, d.department_head =:employee where d.department_id=:id",
	nativeQuery=true)
	void updateDepartmentDetails(@Param("id") Long id, @Param("name") String name,@Param("createdDate") Date createdDate,@Param("employee") Long employee);

	
	@Transactional
	@Modifying
	@Query(value ="DELETE from department where department.department_id=:id",nativeQuery=true)
	void deleteDepartmentDetails(@Param("id")Long id);


}
