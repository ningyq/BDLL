package com.xuptdata.bdll.entity;

import lombok.Data;

/**
 * @Author: ningyq
 * @Date: 2019/4/18 12:06
 */
@Data
public class Response {
    private String status;

    private String msg;

    public Response(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
