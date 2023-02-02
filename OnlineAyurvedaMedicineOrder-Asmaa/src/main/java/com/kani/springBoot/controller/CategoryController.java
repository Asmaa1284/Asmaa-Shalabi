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

import com.kani.springBoot.entity.Categorys;
import com.kani.springBoot.entity.Medicine;
import com.kani.springBoot.exception.CategoryException;
import com.kani.springBoot.exception.MedecineNotFoundException;
import com.kani.springBoot.service.CategoryService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(value="/category")

public class CategoryController {
	@Autowired
	private CategoryService cS;
	/****************************
	 * Method: add Category 
	 * @RequestMapping: It is used to map HTTP requests to handler methods of MVC and REST controllers.
	 * @RestController: It is used to create RESTful web services using MVC.
	 * Description: It is used to add into the category table 
	 * @returns category It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ****************************/
	@PostMapping(path="add")
	public ResponseEntity<Categorys> add(@RequestBody Categorys cate){
		return new ResponseEntity<Categorys>(cS.addCate(cate),HttpStatus.CREATED);
		
	}
	/****************************
	 * Method: Update Category 
	 * Description: It is used to update Category in Category table
	 * @returns Category It returns String type message 
	 * @PutMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * @PathVariable:  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ****************************/

	@PutMapping({ "/updatecat/{id}" })
	public ResponseEntity<Categorys> updateCat(@RequestBody Categorys cate, @PathVariable int id)
			throws CategoryException {
		cS.updateById(id,cate);
		return new ResponseEntity<Categorys>(cate, HttpStatus.ACCEPTED);
	}
	/****************************
	 * Method: Get A Category by id 
	 * Description: It is used to view  category by id
	 * @returns Category list It returns a Category type message 
	 * @GetMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *@PathVariable :  It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 *
	 ****************************/
	@GetMapping(path="/get/{id}")
	public ResponseEntity<Categorys>getCatById(@PathVariable Integer id) throws CategoryException{
		return new ResponseEntity<Categorys>(cS.getById(id),HttpStatus.OK);
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
	public ResponseEntity<List<Categorys>>getAll(){
		return new ResponseEntity<List<Categorys>>(cS.getAll(),HttpStatus.OK);
	}
	/****************************
	 * Method: Delete  Category By Id 
	 * Description: It is used to delete category from Category table
	 * @returns Category  It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP PUT requests matched with given URI expression.
	 *
	 * 
	 ****************************/
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Categorys> deleteCat(@PathVariable Integer id) throws CategoryException {
		return new ResponseEntity<Categorys>(cS.deleteById(id), HttpStatus.OK);
		
	}

}
