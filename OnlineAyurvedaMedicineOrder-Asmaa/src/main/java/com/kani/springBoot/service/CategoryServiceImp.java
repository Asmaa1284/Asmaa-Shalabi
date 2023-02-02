package com.kani.springBoot.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kani.springBoot.entity.Categorys;
import com.kani.springBoot.exception.CategoryException;
import com.kani.springBoot.repositry.CategoryRepository;

import jakarta.transaction.Transactional;
@Service
@Component
@Transactional

public class CategoryServiceImp implements CategoryService {
	@Autowired
	private CategoryRepository cat;

	@Override
	public Categorys addCate(Categorys cate) {
		cat.save(cate);
		
		return cate;
	}

	@Override
	public List<Categorys> getAll() {
		
		return cat.findAll();
	}

	@Override
	public Categorys deleteById(Integer id) throws CategoryException {
		Categorys c= cat.findById(id).get();
		cat.findById(id).orElseThrow(()->  new CategoryException("Not Found") );
		cat.deleteById(id);
		return c;
	}

	@Override
	public Categorys updateById(Integer id, Categorys cate) throws CategoryException {
		Optional<Categorys> c= cat.findById(id);
		if(c.isPresent()) {
			Categorys ca= c.get();
			ca.setId(id);
			ca.setName(cate.getName());
			cat.save(ca);
			return ca;
		}else
		throw new  CategoryException("Not Found") ;
		
		
	}

	@Override
	public Categorys getById(Integer id) throws CategoryException {
		
	 cat.findById(id).orElseThrow(()->  new CategoryException("Not Found") );
	 return cat.findById(id).get();
		
	
	}

}
