package com.liwenguang.api.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author liwenguang
 * @Date 2019-05-18 13:42
 * @Description
 */
@Data
@Entity
@Table(name = "job_desc")
public class JobDesc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String salary;
    private String city;
    private String require;
    private String source;
}