package com.xuptdata.bdll.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Classify {
    private Integer id;

    private String name;

    private String remark;

    private Boolean delFlag;

    private Date createTime;

    private Date updateTime;
}