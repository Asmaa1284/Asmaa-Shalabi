package com.kani.springBoot.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine")
@Embeddable 
public class Medicine implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String company;
	private String typeOfMed;
	private String ingridients;
	private float price;
	
	@OneToOne(fetch= FetchType.EAGER)
	 @JsonIgnoreProperties(value = {"medicine", "hibernateLazyInitializer"})
	 @JoinColumn(name="category_id",nullable=true)
	private Categorys cate;
	 
	
	public Categorys getCate() {
		return cate;
	}
	
	public void setCate(Categorys cate) {
		this.cate = cate;
	}
	public String getTypeOfMed() {
		return typeOfMed;
	}
	public void setTypeOfMed(String typeOfMed) {
		this.typeOfMed = typeOfMed;
	}
	 public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", company=" + company + ", ingridients=" + ingridients + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIngridients() {
		return ingridients;
	}
	public void setIngridients(String ingridients) {
		this.ingridients = ingridients;
	}
	

}
