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

import com.kani.springBoot.entity.Order;
import com.kani.springBoot.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/order")

public class OrderController {
@Autowired
private OrderService oS;
@PostMapping(path="add/{cartId}/{medId}")
public ResponseEntity<Order> addOrder(@PathVariable int cartId, @PathVariable int medId){
	return new ResponseEntity<Order>(oS.addOrder(cartId, medId),HttpStatus.CREATED);
}
@GetMapping(path="viewall")
public ResponseEntity<List<Order>>viewAll(){
	return new ResponseEntity<List<Order>>(oS.showAllOrder(),HttpStatus.OK);
	
}
@PutMapping(path="updateorder/{id}")
public ResponseEntity<Order> updateOrder(@PathVariable int id,@RequestBody Order order){
	return new ResponseEntity<Order>(oS.updateOrder(id, order),HttpStatus.OK);
}
@PutMapping(path="updatedstatus/{id}/{status}")
public ResponseEntity<Order> updateStatus(@PathVariable int id,@PathVariable String status){
	return new ResponseEntity<Order>(oS.updateOrderStatus(id, status),HttpStatus.OK);
}
@DeleteMapping(path="cancel/{id}")
public ResponseEntity<Order>cancell(@PathVariable int id){
	return new ResponseEntity<Order>(oS.cancelOrder(id),HttpStatus.ACCEPTED);
}
@GetMapping(path="showCustomerOrder/{id}")
public ResponseEntity<List<Order>> showCustOrders(@PathVariable int id){
	return new ResponseEntity<List<Order>>(oS.showOrderByCustomer(id),HttpStatus.OK);
}
@GetMapping(path="vieworder/{id}")
public ResponseEntity<Order>showById(@PathVariable int id){
	return new ResponseEntity<Order>(oS.showOrder(id),HttpStatus.OK);
}
}
