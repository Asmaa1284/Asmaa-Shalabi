package com.kani.springBoot.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;



import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int customerId;
 private String userName;
 private String pass;
 private String email;
 private String lastName;
 private String firstName;
public int getiD() {
	return customerId;
}
public void setiD(int iD) {
	this.customerId = iD;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
@Override
public String toString() {
	return "Customer [iD=" + customerId + ", userName=" + userName + ", pass=" + pass + ", email=" + email + ", lastName="
			+ lastName + ", firstName=" + firstName + "]";
}
 
	
	
	
	
}
