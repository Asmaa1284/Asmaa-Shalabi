package com.kani.springBoot.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kani.springBoot.entity.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
	public List<Medicine> findMedByCate(Integer id);
	public Optional<Medicine> findByName(String name); 
	

}
