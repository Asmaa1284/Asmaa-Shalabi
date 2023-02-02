package com.kani.springBoot.service;

import java.util.List;

import com.kani.springBoot.entity.Employee;
import com.kani.springBoot.exception.UserNotFoundException;

public interface EmployeeService {
	public Employee addAdmin(Employee a);
	public List<Employee> viewAllAdmin();
	public Employee getById(Integer iD);
	public Employee delete(Employee a);
	public Employee update(Employee a);
	public Employee validateAdmin(Integer employeeId)throws UserNotFoundException;
	

}
