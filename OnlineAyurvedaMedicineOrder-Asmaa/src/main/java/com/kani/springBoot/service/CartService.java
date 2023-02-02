package com.kani.springBoot.service;

import java.util.List;

import com.kani.springBoot.entity.*;

public interface CartService {
	Cart createCart(Customer c);
	List<Cart> showAll();
	Cart deleteMedicine(int cartId,int medId);
	Cart deleteMedicines(int cartId);
	Cart addToCart(int cartId,int medId);
	List<Medicine> viewMedicine(int cartId);
	
	Cart addMedicine(int cartId,String medName,int q);
	Cart viewCartInfo(int cartId);

}
