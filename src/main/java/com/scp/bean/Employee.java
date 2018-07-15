package com.scp.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Employee {
@GeneratedValue(strategy=GenerationType.AUTO)
@Id
	private int employeeId;
	private String employeeName;
	
	public Employee() {
		super();
	}
	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public int setEmployeeId(int employeeId) {
		return this.employeeId = employeeId;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@Override
	public String toString() {
		return "\n Employee employeeId=" + employeeId + ", employeeName=" + employeeName + "";
	}
}

class InsertAlphabetsOnly extends Exception{
	/**
	 *
	 *
	 *
	 */
	
}