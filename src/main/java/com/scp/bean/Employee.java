package com.scp.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Employee {
@Id
	private String UserName;
	private String Password;
	
	public Employee() {
		super();
	}

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Employee [UserName=" + UserName + ", Password=" + Password + "]";
	}
	

}
	

