package com.hsjjc.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity  
@Table(name="tb_product")  
public class TbProduct implements Serializable {

	private static final long serialVersionUID = 3996656585935233284L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;
	/**
	 * 分类id
	 */
	private Long cid;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品价格
	 */
	private Double price;
	/**
	 * 商品库存量
	 */
	private Integer num;
	
}
