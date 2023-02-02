package com.kani.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.*;
import com.kani.springBoot.exception.CartNotFoundException;
import com.kani.springBoot.exception.CategoryException;
import com.kani.springBoot.exception.MedecineNotFoundException;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.repositry.CartRepository;
import com.kani.springBoot.repositry.CustomerRepository;
import com.kani.springBoot.repositry.MedicineRepository;

import jakarta.transaction.Transactional;

@Service
@Component
@Transactional
public class CartSeviceImpl implements CartService{
	@Autowired
	private CartRepository cartRep;
	@Autowired
	private CustomerRepository cust;
	@Autowired
	private MedicineRepository med;

	@Override
	public Cart createCart(Customer c) throws UserNotFoundException {
		try {
		
		
		Cart cart= new Cart(c);
		cartRep.count();
		
		cartRep.save(cart);
		return cart;
		
		}catch (UserNotFoundException e) {
			
			throw e ;
		}
		
	}

	@Override
	public List<Cart> showAll() {
		
		return cartRep.findAll();
	}

	
	@Override
	public Cart deleteMedicine(int id, int medId) {
		try {
		Cart cart= cartRep.findById(id).get();
		Medicine m= med.findById(medId).get();
		cart.getMedList().remove(m);
		cart.setQuantity(cart.getQuantity()-1);
		cart.setCost(cart.getCost()-m.getPrice());
		cartRep.save(cart);
		return cart;
		}catch(CartNotFoundException | MedecineNotFoundException e) {
			throw e;
		}
		
	}

	@Override
	public Cart deleteMedicines(int id) {
		Cart cart= cartRep.findById(id).get();
		cartRep.findById(id).orElseThrow(()->  new CartNotFoundException("Not Found") );
		cart.getMedList().clear();
		cart.setQuantity(0);
		cart.setCost(0);
		cartRep.save(cart);
		return cart;
	}

	@Override
	public Cart addToCart(int id, int medId) {
		try {
		Cart cart= cartRep.findById(id).get();
		Medicine me= med.findById(medId).get();
		cart.getMedList().add(me);
		cart.setQuantity(cart.getQuantity()+1);
		cart.setCost(cart.getCost()+ me.getPrice());
		cartRep.save(cart);
		return cart;}
		catch(CartNotFoundException | MedecineNotFoundException e) {
			throw e;
		}
		
		
	}

	@Override
	public List<Medicine> viewMedicine(int id) {
		Cart cart = cartRep.findById(id).get();
		cartRep.findById(id).orElseThrow(()->  new CartNotFoundException("Not Found") );
		
		return cart.getMedList();
	}

	@Override
	public Cart addMedicine(int id, String name,int q) throws CartNotFoundException , MedecineNotFoundException  {
		try {
		Cart c= cartRep.findById(id).get();
		Medicine m= med.findByName(name).get();
		if(c.getMedList().contains(m)) {
			c.setQuantity(c.getQuantity()+q);
			c.setCost(c.getCost()+((m.getPrice()*q)));
		}else {
		
		c.getMedList().add(m);
		c.setQuantity(c.getQuantity()+q);
		c.setCost(c.getCost()+((m.getPrice()*q)));
		}
		
		cartRep.save(c);
		return c;
		}catch(CartNotFoundException | MedecineNotFoundException e ) {
			throw  e;
		}
	}

	@Override
	public Cart viewCartInfo(int id) throws CartNotFoundException{
		cartRep.findById(id).orElseThrow(()->  new CartNotFoundException("Not Found") );

		return cartRep.findById(id).get();
	}

}
