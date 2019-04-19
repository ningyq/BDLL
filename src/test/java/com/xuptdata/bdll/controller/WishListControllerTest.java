package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.service.WishListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: ningyq
 * @Date: 2019/4/18 23:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WishListControllerTest {
    @Autowired
    WishListService service;

    @Test
    public void getById() {
        WishList wishList = service.getById(2);
        System.out.println(wishList.getCreateTime());
    }

    @Test
    public void getByName() {
        List<WishList> wishLists = service.getByName("Java核心技术");
        System.out.println(wishLists);
    }
}