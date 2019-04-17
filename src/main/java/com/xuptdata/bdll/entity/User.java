package com.xuptdata.bdll.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean locked;
}