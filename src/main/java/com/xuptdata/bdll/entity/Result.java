package com.xuptdata.bdll.entity;

import lombok.Data;

/**
 * @Author: ningyq
 * @Date: 2019/4/18 12:06
 */
@Data
public class Result {
    private String status;

    private String msg;

    private Object data;

    public Result(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
