package com.hsjjc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity  
@Table(name="tb_user")  
public class TbUser implements Serializable {

    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long id;

    private String username;
    
    private String nickname;
    
    private String password;

    private String phone;

//    private String email;

    private Date created;

    private Date updated;

}