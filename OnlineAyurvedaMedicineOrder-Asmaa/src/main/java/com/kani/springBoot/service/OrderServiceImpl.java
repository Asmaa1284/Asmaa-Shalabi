package com.kani.springBoot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.Cart;
import com.kani.springBoot.entity.Customer;
import com.kani.springBoot.entity.Medicine;
import com.kani.springBoot.entity.Order;
import com.kani.springBoot.exception.CartNotFoundException;
import com.kani.springBoot.exception.MedecineNotFoundException;
import com.kani.springBoot.exception.OrderNotFoundException;
import com.kani.springBoot.exception.UserNotFoundException;
import com.kani.springBoot.repositry.CartRepository;
import com.kani.springBoot.repositry.CustomerRepository;
import com.kani.springBoot.repositry.MedicineRepository;
import com.kani.springBoot.repositry.OrderRepository;

import jakarta.transaction.Transactional;

@Service
@Component
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository oR;
	@Autowired
	private MedicineRepository med;
	@Autowired
	private CartRepository cart;
	@Autowired
	private CustomerRepository cust;

	@Override
	public Order addOrder(int cartId, int medId) throws CartNotFoundException, MedecineNotFoundException {
		try {
		Order order= new Order(cart.findById(cartId).get(),med.findById(medId).get());
		float total=cart.findById(cartId).get().getMedList().stream().mapToDouble(Medicine::getPrice).count();
		System.out.println(total);
		Cart ca= cart.findById(cartId).get();
		
		
		order.setTotalCost(ca.getCost());
		oR.save(order); 
		return order;
		}
		catch(CartNotFoundException | MedecineNotFoundException e) {
			System.out.println("No id here"+ e);
			return null;
		}
	}

	@Override
	public Order updateOrder(int id, Order order) {
		Order updatedOrder= oR.findById(id).get();
		updatedOrder.setId(order.getId());
		updatedOrder.setCart(order.getCart());
       updatedOrder.setCost(order.getCost());
		updatedOrder.setCust(order.getCust());
		updatedOrder.setMed(order.getMed());
		updatedOrder.setStatus(order.getStatus());
		updatedOrder.setDispatchDate(order.getDispatchDate());
		oR.save(updatedOrder);
		return updatedOrder;
	}

	@Override
	public Order updateOrderStatus(int id, String status) {
		Order updatedOrder= oR.findById(id).get();
		updatedOrder.setStatus(status);
		oR.save(updatedOrder);
		return updatedOrder;
	}

	@Override
	public Order cancelOrder(int id) {
		Optional<Order> order= oR.findById(id);
		order.orElseThrow(()->(new UserNotFoundException("No Customer with this I.D")));
		oR.deleteById(id);
		
		return order.get();
		
		
	}

	@Override
	public int calculateTotalCost(int cost) {
		
		return 0;
	}

	@Override
	public Order showOrder(int id) throws OrderNotFoundException {
		oR.findById(id).orElseThrow(()->new OrderNotFoundException("This Order Id not Found"));
		return oR.findById(id).get();
	}

	@Override
	public List<Order> showAllOrder() {
		
		return oR.findAll();
	}

	@Override
	public List<Order> showOrderByCustomer(int iD) {
		//Customer c=cust.findById(iD).get();
		return oR.findAll().stream().filter(o-> (o.getCust().getiD()== iD)).collect(Collectors.toList());
		
		//return oR.findAllOrderByCustomerId(c.getiD());
	}

}
