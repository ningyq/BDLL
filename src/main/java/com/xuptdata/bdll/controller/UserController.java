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
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getList() {
        return userService.getList();
    }

    @GetMapping("/id/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }
}
