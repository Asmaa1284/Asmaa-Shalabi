package com.kani.springBoot.service;

import java.util.List;

import com.kani.springBoot.entity.Order;

public interface OrderService {
	Order addOrder(int cartId,int medId);
	Order updateOrder(int id,Order order);
	Order updateOrderStatus(int id,String staus);
	Order cancelOrder(int id);
	int calculateTotalCost(int cost);
	Order showOrder(int id);
	List<Order> showAllOrder();
	List<Order>showOrderByCustomer(int id);
	

}
