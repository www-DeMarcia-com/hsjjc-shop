package com.hsjjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.hsjjc.feignservice.CategoryFeignService;
import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;

@Service
@CacheConfig(cacheNames="categories")
public class CategoryService {
	@Autowired
	CategoryFeignService categoryFeignService;
	
	public List<CategoriesSum> findAll(){
		return categoryFeignService.queryAll();
	}
}
