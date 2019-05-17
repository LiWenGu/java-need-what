package com.liwenguang.api.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author liwenguang
 * @Date 2019-05-18 01:06
 * @Description
 */
@Entity
@Table(name = "t_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;

}