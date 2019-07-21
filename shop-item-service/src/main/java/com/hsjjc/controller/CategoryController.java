package com.hsjjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.hsjjc.item.service.api.CategoryServiceApi;
import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;
import com.hsjjc.service.CategoryService;

@RestController
@CacheConfig(cacheNames="categories")
public class CategoryController implements CategoryServiceApi{
	@Autowired
	CategoryService categoryService;

	@Override
	public TbCategory querybycid(Long cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbCategory querybycname(String cname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Cacheable(key="'allCategories'")
	public List<CategoriesSum> queryAll() {
		return categoryService.findAll();
	}
	/*public List<TbCategory>findAll(){
		
	}*/
	
}
