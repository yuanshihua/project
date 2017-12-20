package com.demo.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_dept database table.
 * 
 */
@Entity
@Table(name="emp_dept")
@NamedQuery(name="EmpDept.findAll", query="SELECT e FROM EmpDept e")
public class EmpDept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public EmpDept() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}