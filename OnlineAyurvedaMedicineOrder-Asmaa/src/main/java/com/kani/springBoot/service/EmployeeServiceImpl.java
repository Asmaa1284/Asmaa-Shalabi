package com.kani.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.Employee;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.repositry.EmployeeRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional

public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository aR;

	@Override
	public Employee addAdmin(Employee a) {
		Employee ad = aR.save(a);
		return ad;
	}


	@Override
	public List<Employee> viewAllAdmin() {
		List<Employee> list= aR.findAll();
		return list;
	}

	@Override
	public Employee delete(Employee a) {
		aR.delete(a);
		return a ;
	}

	@Override
	public Employee update(Employee a) {
		Employee up= aR.findByEmployeeId(a.getiD());
		up.setiD(a.getiD());
		up.setUserName(a.getUserName());
		up.setPass(a.getPass());
		
		return a;
	}

	@Override
	public Employee validateAdmin(Integer employeeId) throws UserNotFoundException {
		Employee admin= aR.findByEmployeeId(employeeId);
		if(admin == null) {
			throw new UserNotFoundException("Employee Not Found"); 
		}
		return admin;
	}


	@Override
	public Employee getById(Integer iD) {
		Employee admin = aR.findByEmployeeId(iD);
		if(admin == null) {
			throw new UserNotFoundException("User not Found");
		}
		return admin;
	}

}
