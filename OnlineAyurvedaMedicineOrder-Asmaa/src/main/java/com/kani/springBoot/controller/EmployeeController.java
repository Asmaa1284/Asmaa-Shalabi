package com.kani.springBoot.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kani.springBoot.entity.Employee;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.service.EmployeeService;

import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping(value={"/loginController"})

public class EmployeeController {
	private static final HttpStatus HTTPSTATUS = null;
	@Autowired
	HttpSession session;
	@Autowired
	private EmployeeService as;
	/****************************
	* Method: addUser
	 * Description: It allows to add the User.
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URL expression.
	 * @Autowired: It enables to inject object dependency implicitly.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
     */
	@PostMapping(path="/add")
	public ResponseEntity<Employee> addAdmin(@RequestBody Employee a){
		if(a.getiD()==0) {
			return new ResponseEntity("invalid",HTTPSTATUS.NOT_FOUND);
		}
		Employee ad = as.addAdmin(a);
		return new ResponseEntity(ad,HttpStatus.OK);
	
		
	}
	/****************************
	 * Method: getAllUser
	 * Description: It allows to view the users.
	 * @PathVariable: It is used to handle template variables in the request URL
	 * @GetMapping:It is used to handle the HTTP GET requests matched with given URL Expression.
     */
	@GetMapping(path="/getEmployees")
	public ResponseEntity<List<Employee>> viewEmployee(){
		List<Employee> list= as.viewAllAdmin();
		return new ResponseEntity(list,HTTPSTATUS.OK);
		
	}
	@GetMapping(path="/getEmployee/{iD}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer iD){
		return new ResponseEntity<Employee>(as.getById(iD),HTTPSTATUS.ACCEPTED);
	}

	/****************************
	 * Method: removeUser
	 * Description: It allows to remove the user.
	 * @RequestBody: It is used to bind HTTP request body with a domain object in method parameter or return type
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched with given URL expression.
     */
	@DeleteMapping(path="/deleteEmployee")
	public ResponseEntity<Employee> delete(@RequestBody Employee e){
		if(e.getiD()==0) {
			return new ResponseEntity("invalid",HttpStatus.OK);
		}
		return new ResponseEntity( as.delete(e),HttpStatus.OK);
	}
	@GetMapping(path="/signout")
	public ResponseEntity<Employee> signout(){
		session.invalidate();
		return new ResponseEntity("LoggedOut",HttpStatus.OK);
	}
	
	
	

}
