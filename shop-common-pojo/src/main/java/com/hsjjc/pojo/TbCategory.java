package com.hsjjc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 商品分类
 * 
 * @author Administrator
 *
 */
@Data
@Entity  
@Table(name="tb_category")  
public class TbCategory implements Serializable {
	private static final long serialVersionUID = 1994225192383329978L;
	/**
	 * 商品 id Long 自增
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;
	/**
	 * 商品名称
	 */
    private String name;
    /**
     * 排序
     */
    private Integer sortOrder;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date updated;
    /**
     * 图片地址
     */
    private String imgurl;
    

}