package com.kani.springBoot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int employeeId;
	private String userName;
	private String pass;
	
	public int getiD() {
		return employeeId;
	}
	public void setiD(int iD) {
		this.employeeId = iD;
	}
	public Employee() {
		super();
		
	}
	@Override
	public String toString() {
		return "Employee [iD=" + employeeId + ", userName=" + userName + ", pass=" + pass + " ]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
