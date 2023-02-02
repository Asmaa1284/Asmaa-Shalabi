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
import org.springframework.web.bind.annotation.RestController;

import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.entity.Medicine;
import com.kani.springBoot.exception.MedecineNotFoundException;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.service.MedicineService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/medicine")
public class MedecineController {
@Autowired
private MedicineService medSer;
@GetMapping(path="/getMedByName/{name}")
public ResponseEntity<Medicine> getByName(@PathVariable String name){
	return new ResponseEntity<Medicine>(medSer.getByName(name),HttpStatus.OK);
}
/****************************
 * Method: addMedicine 
 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
 * @RestController: It is used to create RESTful web services using MVC.
 * Description: It is used to add into the medicine table 
 * @returns medicine It returns String type message
 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
 * 
 ****************************/
@PostMapping(path="add")
public ResponseEntity<Medicine> add(@RequestBody Medicine medicine){
	return new ResponseEntity<Medicine>(medSer.addNewMed(medicine),HttpStatus.CREATED);
	
}
/****************************
 * Method: Update Medicine 
 * Description: It is used to update medicine in medicine table
 * @returns medicine It returns String type message 
 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
 * @PathVariable:  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
 ****************************/

@PutMapping({ "/updatemed/{id}" })
public ResponseEntity<Medicine> updateMed(@RequestBody Medicine medicine, @PathVariable int id)
		throws MedecineNotFoundException {
	medSer.updateMed(medicine, id);
	return new ResponseEntity<Medicine>(medicine, HttpStatus.ACCEPTED);
}
/****************************
 * Method: Get A Medicine by id 
 * Description: It is used to view  medicine by id
 * @returns medicine list It returns list type message 
 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
 *@PathVariable :  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
 *
 ****************************/
@GetMapping(path="/get/{id}")
public ResponseEntity<Medicine>getMedById(@PathVariable Integer id) throws MedecineNotFoundException{
	return new ResponseEntity<Medicine>(medSer.getMed(id),HttpStatus.OK);
}
/****************************
 * Method: Get All Medicine 
 * Description: It is used to view all medicine in medicine table
 * @returns medicine list It returns list type message 
 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
 *
 * 
 ****************************/
@GetMapping(path="/getAll")
public ResponseEntity<List<Medicine>>getAll(){
	return new ResponseEntity<List<Medicine>>(medSer.getAllMeds(),HttpStatus.OK);
}
/****************************
 * Method: Delete  Medicine By Id 
 * Description: It is used to delete medicine from medicine table
 * @returns medicine  It returns String type message 
 * @DeleteMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
 *
 * 
 ****************************/
@DeleteMapping(path="/delete/{id}")
public ResponseEntity<Medicine> deleteMed(@PathVariable Integer id) throws MedecineNotFoundException {
	return new ResponseEntity<Medicine>(medSer.deleteMedicine(id), HttpStatus.OK);
	
}

}
