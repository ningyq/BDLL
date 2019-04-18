package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.User;
import com.xuptdata.bdll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/all")
    public List<User> getList() {
        return userService.getList();
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }
}
