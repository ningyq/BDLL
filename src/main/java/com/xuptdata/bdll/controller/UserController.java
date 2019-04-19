package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.entity.User;
import com.xuptdata.bdll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/list")
    public Result getList(int pageNum, int pageSize) {
        PageInfo pageInfo = userService.getList(pageNum, pageSize);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getById(int id){
        User user = userService.getById(id);
        if (user == null) {
            return new Result("error", "未查找到数据");
        }
        return new Result("success", "查找成功", user);
    }
}
