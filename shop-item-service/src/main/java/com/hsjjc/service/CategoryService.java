package com.hsjjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.hsjjc.dao.CategoryDao;
import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	
	public List<CategoriesSum> findAll(){
		return categoryDao.findAll();
	}
}
