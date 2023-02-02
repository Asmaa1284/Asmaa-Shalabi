package com.kani.springBoot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.springBoot.entity.Cart;
import com.kani.springBoot.entity.Customer;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	

}
