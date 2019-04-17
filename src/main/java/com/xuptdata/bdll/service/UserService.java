package com.xuptdata.bdll.service;

import com.xuptdata.bdll.entity.User;

import java.util.List;

public interface UserService {

    List<User> getList();

    User getById(int id);
}
