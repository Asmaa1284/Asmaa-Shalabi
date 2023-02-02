package com.kani.springBoot.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.repositry.CustomerRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
    
	
	@Autowired
	private CustomerRepository cR;
	
	@Override
	public Customer addNewCustomer(Customer customer) throws UserNotFoundException {
		
		cR.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) throws UserNotFoundException {
		Optional<Customer> findById= cR.findById(customerId);
		findById.orElseThrow(()->(new UserNotFoundException("No Customer with this I.D")));
		cR.deleteById(customerId);
		return findById.get();
		
		
	}

	@Override
	public Customer getCustomer(int customerId) throws UserNotFoundException {
		
		Optional<Customer> findById=cR.findById(customerId);
		return findById.orElseThrow(() -> new UserNotFoundException("No Customer found with this I.D"+ customerId));
	
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) throws UserNotFoundException {
		Optional<Customer>find= cR.findById(customerId);
		if(find.isPresent()) {
		  Customer custUpdated= find.get();
		  //custUpdated.setiD(customer.getiD());
		  custUpdated.setFirstName(customer.getFirstName());
		  custUpdated.setLastName(customer.getLastName());
		  custUpdated.setEmail(customer.getEmail());
		  custUpdated.setPass(customer.getPass());
		  custUpdated.setUserName(customer.getUserName());
		  
		  cR.save(custUpdated);
		  return custUpdated;
		  
		}
		
		return find.orElseThrow(()-> new UserNotFoundException("Not Found"));
	}

	@Override
	public List<Customer> getAllCustomers() throws UserNotFoundException {
		if (cR.findAll().isEmpty())
			throw new UserNotFoundException("There are no records");

		return cR.findAll();
		
	}

	@Override
	public Customer validateCustomer(Customer customer, String username, String password) {
		if (username == null && password == null) {
			System.out.println("Values cannot be empty");
		}
		return customer;
	}

}
