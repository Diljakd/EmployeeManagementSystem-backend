package com.springbootjava.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name = "Department_Head") // Assuming your department table has a column named "department_id"
	private Employee employee;
	
	@Override
    public String toString() {
        return "Department [name=" + name + ", createdDate=" + createdDate + ","
        		+ " employee=" + employee + "]";
    }
}
