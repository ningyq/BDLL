package com.xuptdata.bdll.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Books {
    private Integer id;

    private String name;

    private Integer classifyId;

    private Integer number;

    private Boolean status;

    private String description;

    private String imgUrl;

    private Boolean delFlag;

    private String remark;

    private Date createTime;

    private Date updateTime;
}