package com.kani.springBoot.service;

import java.util.List;

import com.kani.springBoot.entity.Categorys;

public interface CategoryService {
	Categorys addCate(Categorys cat);
	List<Categorys> getAll();
	Categorys deleteById(Integer id);
	Categorys updateById(Integer id,Categorys cate);
	Categorys getById(Integer id);

}
