package com.kani.springBoot.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.springBoot.entity.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findById(int customerId);

}
