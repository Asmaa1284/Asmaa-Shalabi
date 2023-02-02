package com.kani.springBoot.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="orders")

public class Order implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	@Temporal(value = TemporalType.DATE)
	private LocalDate orderDate;
	private float cost;
	private String status;
	private LocalDate dispatchDate;
	private float totalCost;
	public Order() {
		super();
	}

	
	
	@ManyToOne(cascade = CascadeType.ALL)
	// @JsonIgnoreProperties(value = {"customer", "hibernateLazyInitializer"})
	 @JoinColumn(name="customer_id",nullable=false)
	private Customer cust;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id",nullable=true)
	private Cart cart;
	
	@ManyToOne(targetEntity=Medicine.class)
	//@JsonIgnoreProperties(value = {"medicine", "hibernateLazyInitializer"})
    @JoinColumn(name="med_id",nullable=true)
	private Medicine med;
	

	public Order(Cart cart, Medicine med) {
		super();
		this.cost= med.getPrice();
		this.orderDate= LocalDate.now();
		this.cart = cart;
		this.med = med;
		//this.totalCost= cart.getMedList().stream().mapToDouble(Medicine::getPrice).count();
		this.cust= cart.getCust();
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", cost=" + cost + ", dispatchDate=" + dispatchDate
				+ ", totalCost=" + totalCost + ", status=" + status + ", cust=" + cust + ", cart=" + cart + ", med="
				+ med + "]";
	}
	
	

}
