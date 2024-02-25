package com.springbootjava.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "department")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Department() {
		
	}
	public Department(String name, Date createdDate, Employee employee) {
		super();
		this.name = name;
		this.createdDate = createdDate;
		this.employee = employee;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "name")
	private String name;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Department_Head",referencedColumnName = "employeeId") // Assuming your department table has a column named "department_id"
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Employee employee;
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", createdDate=" + createdDate
				+ ", employee=" + employee + ", getDepartmentId()=" + getDepartmentId() + ", getName()=" + getName()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getEmployee()=" + getEmployee() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
