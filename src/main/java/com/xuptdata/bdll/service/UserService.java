package com.xuptdata.bdll.service;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.User;

import java.util.List;

public interface UserService {

    PageInfo getList(int pageNum, int pageSize);

    User getById(int id);
}