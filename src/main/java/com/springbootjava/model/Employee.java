package com.springbootjava.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employee() {
		
	}
	public Employee(String name, Date dateOfBirth, long salary, String address, String role, Date joiningDate,
			long yearlyBonusPercentage, Employee reportingManager, Department department) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.address = address;
		this.role = role;
		this.joiningDate = joiningDate;
		this.yearlyBonusPercentage = yearlyBonusPercentage;
		this.reportingManager = reportingManager;
		this.department = department;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public long getYearlyBonusPercentage() {
		return yearlyBonusPercentage;
	}
	public void setYearlyBonusPercentage(long yearlyBonusPercentage) {
		this.yearlyBonusPercentage = yearlyBonusPercentage;
	}
	public Employee getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(Employee reportingManager) {
		this.reportingManager = reportingManager;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "name")
	private String name;
	
	@Column(name = "date_Of_Birth")
	private Date dateOfBirth;
	
	@Column(name = "salary")
	private long salary;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "yearly_bonus_percentage")
	private long yearlyBonusPercentage;
	
	@ManyToOne
    @JoinColumn(name = "reporting_manager")
	private Employee reportingManager;
	
	@ManyToOne
	@JoinColumn(name = "department") // Assuming your department table has a column named "department_id"
	private Department department;
	
	 @Override
	    public String toString() {
	        return "Employee{" +
	                "employeeId=" + employeeId +
	                ", name='" + name + '\'' +
	                ", dateOfBirth=" + dateOfBirth +
	                ", salary=" + salary +
	                ", address='" + address + '\'' +
	                ", role='" + role + '\'' +
	                ", joiningDate=" + joiningDate +
	                ", yearlyBonusPercentage=" + yearlyBonusPercentage +
	                ", reportingManager=" + reportingManager +
	                ", department=" + department +
	                '}';
	    }
}