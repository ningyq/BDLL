package com.xuptdata.bdll.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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