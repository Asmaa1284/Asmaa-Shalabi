package com.kani.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping(value="/customer")

public class CustomerController {
	@Autowired
	private CustomerService cs;
	/****************************
	 * Method: addCustomer 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * Description: It is used to add into the customer table 
	 * @returns customer It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ****************************/
	@PostMapping(path="/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
		cs.addNewCustomer(c);
		return new ResponseEntity<Customer>(c,HttpStatus.CREATED);
		
	}


	@DeleteMapping(path="/delete/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer customerId) throws UserNotFoundException {
		return new ResponseEntity<Customer>(cs.deleteCustomer(customerId), HttpStatus.OK);
		
	}
	/****************************
	 * Method: Get A Medicine by id 
	 * Description: It is used to view  medicine by id
	 * @returns medicine list It returns list type message 
	 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *@PathVariable :  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 *
	 ****************************/
	@GetMapping(path = "/get/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId) throws UserNotFoundException{
		return new ResponseEntity<Customer>(cs.getCustomer(customerId),HttpStatus.OK);
	}
	/****************************
	 * Method: Get All Customer 
	 * Description: It is used to view all customer in customer table
	 * @returns customer list It returns list type message 
	 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *@PathVariable :  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 *
	 ****************************/
	@GetMapping(path = "/getAll")
	public ResponseEntity<List<Customer>> viewAll(){
		return new ResponseEntity<List<Customer>>(cs.getAllCustomers(),HttpStatus.OK);
	}
	/****************************
	 * Method: Update Customer 
	 * Description: It is used to update customer in customer table
	 * @returns customer It returns String type message 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @PathVariable:  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ****************************/
	

		@PutMapping({ "/updateCustomer/{customerId}" })
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int customerId)
				throws UserNotFoundException {
			cs.updateCustomer(customer, customerId);
			return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
		}
		@GetMapping(path = "/validateCustomer/{userName}/{pass}")
		public ResponseEntity<Customer> validateCustomer(@PathVariable Customer customer, @PathVariable String userName,
				@PathVariable String pass) {
			Customer customer1 = cs.validateCustomer(customer, userName, pass);

			return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
		}
	}


