package com.kani.springBoot.service;

import java.util.List;

import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.exception.UserNotFoundException;



public interface CustomerService {
	
	Customer addNewCustomer(Customer customer);
	Customer deleteCustomer(int customerId) throws UserNotFoundException;
	Customer getCustomer(int customerId) throws UserNotFoundException;
	Customer updateCustomer(Customer customer,int customerId) throws UserNotFoundException;
	List<Customer> getAllCustomers() throws UserNotFoundException;
	Customer validateCustomer(Customer customer,String username, String password);

}
