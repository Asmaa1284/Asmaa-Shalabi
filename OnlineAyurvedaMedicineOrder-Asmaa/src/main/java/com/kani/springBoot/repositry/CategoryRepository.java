package com.kani.springBoot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.springBoot.entity.Categorys;

@Repository
public interface CategoryRepository extends JpaRepository<Categorys, Integer> {

}
