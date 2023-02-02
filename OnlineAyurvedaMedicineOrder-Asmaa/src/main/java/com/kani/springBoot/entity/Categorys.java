package com.kani.springBoot.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="categorys")
public class Categorys implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	private String name;
//	@OneToOne(cascade=CascadeType.ALL,mappedBy="Medicine")
//	private Medicine medicine;
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
//	public Medicine getMedicine() {
//		return medicine;
//	}
//	public void setMedicine(Medicine medicine) {
//		this.medicine = medicine;
//	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
