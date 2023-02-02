package com.kani.springBoot.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.springBoot.entity.Cart;
import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.entity.Order;

@Repository

public interface OrderRepository extends  JpaRepository<Order,Integer> {
	//public List<Order>findAllOrderByCustomerId(Integer customerId);

}
