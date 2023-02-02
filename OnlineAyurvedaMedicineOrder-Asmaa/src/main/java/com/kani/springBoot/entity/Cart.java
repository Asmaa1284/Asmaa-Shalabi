package com.kani.springBoot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	
	private float cost;
	private int quantity;
	@OneToOne(fetch= FetchType.EAGER)
	 @JsonIgnoreProperties(value = {"customer", "hibernateLazyInitializer"})
	 @JoinColumn(name="customer_id",nullable=true)
	private Customer cust;
	@ElementCollection  
	@OneToMany(cascade = CascadeType.ALL )
	@JsonIgnoreProperties(value = {"medicine", "hibernateLazyInitializer"})
	//@JoinColumn(name="medList")
    private List<Medicine> medList = new ArrayList<>();
	public Cart() {
		super();
	}
	
	public Cart(Customer cust) {
		super();
		this.cust = cust;
		this.quantity=this.medList.size();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public List<Medicine> getMedList() {
		return medList;
	}
	public void setMedList(List<Medicine> medList) {
		this.medList = medList;
	}
	

}
