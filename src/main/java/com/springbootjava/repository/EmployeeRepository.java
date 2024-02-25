package com.springbootjava.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootjava.model.Department;
import com.springbootjava.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Transactional
	@Modifying
	@Query(value ="UPDATE employee e SET e.name =:name, e.address =:address, e.joining_date =:joiningDate,"
			+ " e.date_of_birth =:dateOfBirth, e.role=:role, e.salary=:salary, e.yearly_bonus_percentage=:yearlyBonusPercentage,"
			+ "e.department=:department, e.reporting_manager=:reportingManager where e.employee_id=:id",
	nativeQuery=true)
	 void updateEmployeeDetails(@Param("id") Long id, @Param("name") String name, @Param("address") String address,@Param("joiningDate") Date joiningDate,
			 @Param("dateOfBirth") Date dateOfBirth, @Param("role") String role,@Param("salary") long salary,@Param("yearlyBonusPercentage") 
	 long yearlyBonusPercentage, @Param("department") long department,@Param("reportingManager") long reportingManager );
	
	@Transactional
	@Query(value = " SELECT * from employee e where e.department = :id",nativeQuery=true)
	List<Employee> findEmployeeByDeptId(@Param("id") Long id);

	
	@Transactional
	@Modifying
	@Query(value ="UPDATE employee e SET e.department=:departmentId where e.employee_id=:id",
	nativeQuery=true)
	void updateEmployeeDepartmentDetails(@Param("id")Long id, @Param("departmentId")Long departmentId);

	
	@Transactional
	@Query(value = "SELECT employee.employee_id, employee.name FROM employee", nativeQuery = true)
	List<Employee> findEmployeeNameAndId();


}
