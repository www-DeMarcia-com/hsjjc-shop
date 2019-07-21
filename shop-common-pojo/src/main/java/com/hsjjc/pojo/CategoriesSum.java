package com.hsjjc.pojo;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Entity;
/**
 * 商品分类
 * 
 * @author Administrator
 *
 */
@Entity 
public class CategoriesSum extends TbCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7720879009163991618L;
	/**
	 * 商品种类对应有多少商品
	 */
	private Long num;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}  
	
}