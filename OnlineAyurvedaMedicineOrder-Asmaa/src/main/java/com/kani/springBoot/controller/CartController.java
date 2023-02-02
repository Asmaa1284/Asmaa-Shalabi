package com.kani.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kani.springBoot.entity.Cart;
import com.kani.springBoot.entity.Categorys;
import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.entity.Medicine;
import com.kani.springBoot.exception.CartNotFoundException;
import com.kani.springBoot.exception.CategoryException;
import com.kani.springBoot.exception.MedecineNotFoundException;
import com.kani.springBoot.service.CartService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/cart")

public class CartController {
	@Autowired
	private CartService cS;
	/****************************
	 * Method: add Cart 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * Description: It is used to add into the cart table 
	 * @returns category It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ****************************/
	@PostMapping(path="add")
	public ResponseEntity<Cart> add(@RequestBody Customer c){
		return new ResponseEntity<Cart>(cS.createCart(c),HttpStatus.CREATED);
		
	}
	/****************************
	 * Method: Update Cart 
	 * Description: It is used to add medicine to the Cart in Cart table
	 * @returns Category It returns String type message 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @PathVariable:  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ****************************/
	@PatchMapping(path="/add/{id}/{name}/{q}")
	public ResponseEntity<Cart> addMedByName(@PathVariable int id,@PathVariable String name,@PathVariable int q){
		return new ResponseEntity<Cart>(cS.addMedicine(id, name,q),HttpStatus.OK);
	}


	/****************************
	 * Method: Get All Category 
	 * Description: It is used to view all category in category table
	 * @returns medicine list It returns list type message 
	 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *
	 * 
	 ****************************/
	@GetMapping(path="/getAll")
	public ResponseEntity<List<Cart>>getAll(){
		return new ResponseEntity<List<Cart>>(cS.showAll(),HttpStatus.OK);
	}
	/****************************
	 * Method: Delete  Medicine  By Id from cart 
	 * Description: It is used to delete medicine from   cart_med_list table
	 * @returns medicine  It returns String type message 
	 * @PatchMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *
	 * 
	 ****************************/
	@PatchMapping(path="/delete/{id}/{medId}")
	public ResponseEntity<Cart> deleteMed(@PathVariable int id,@PathVariable int medId) throws CartNotFoundException {
		return new ResponseEntity<Cart>(cS.deleteMedicine(id, medId), HttpStatus.OK);
		
	}
	/****************************
	 * Method: Delete All Medicines  from cart 
	 * Description: It is used to delete medicines from   cart_med_list table
	 * @returns medicine  It returns String type message 
	 * @PatchMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *
	 * 
	 ****************************/
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Cart> deleteAllMed(@PathVariable int id) throws CategoryException {
		return new ResponseEntity<Cart>(cS.deleteMedicines(id), HttpStatus.OK);
		
	}
	/*******************************************************************************************
	 * getMed method used @GetMapping to view a list of medicine in the cart
	 * @pathVariable to enter cart Id
	 * @param id
	 * @return list of Medicine from cart table
	 */
	@GetMapping(path="/getMed/{id}")
	public ResponseEntity<List<Medicine>> getMed(@PathVariable int id){
		return new ResponseEntity<List<Medicine>>(cS.viewMedicine(id), HttpStatus.OK);
	}
	
	/*******************************************************************************************
	 * viewCartInfo method used @GetMapping to view cart information
	 * @pathVariable to enter cart Id
	 * @param id
	 * @return cart from cart table
	 */
	@GetMapping(path="/getcart/{id}")
	public ResponseEntity<Cart> viewCartIfo(@PathVariable int id){
		return new ResponseEntity<Cart>(cS.viewCartInfo(id),HttpStatus.OK);
	}
	@PatchMapping(path="/addtocart/{id}/{medId}")
	public ResponseEntity<Cart> addToCart(@PathVariable int id,@PathVariable int medId){
		return new ResponseEntity<Cart>(cS.addToCart(id, medId),HttpStatus.ACCEPTED);
	}

}
