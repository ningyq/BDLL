package com.xuptdata.bdll.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WishList {
    private Integer id;

    private String name;

    private Integer classifyId;

    private String url;

    private String people;

    private Integer status;

    private Boolean delFlag;

    private String remark;

    private Date createTime;

    private Date updateTime;
}