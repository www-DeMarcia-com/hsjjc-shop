package com.hsjjc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.hsjjc.jpa.CategoryJPA;
import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;

@Repository 
public class CategoryDao {
	@Autowired
	CategoryJPA categoryJPA;
	/**
	 * 按照分类id查询分类
	 * @param id
	 * @return
	 */
	public TbCategory findOne(Long id) {
//		Sort sort = new Sort(Sort.Direction.ASC, "id");
		return categoryJPA.findOne(id);
	}
	/**
	 * 查询所有分类，并按照id升序排列
	 * @return
	 */
	public List<CategoriesSum> findAll() {
		return categoryJPA.findAllAndNum();
	}
	/**
	 * 通过名称来查询 like
	 * @return
	 */
	public List<TbCategory> findByNameLike(String name) {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		return categoryJPA.findByNameLike(name,sort);
	}
	public List<TbCategory> findByName(String name) {
		return categoryJPA.findByName(name);
	}
	
	
}
