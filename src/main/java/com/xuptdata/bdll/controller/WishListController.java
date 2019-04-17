package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 18:18
 */
@Controller
@RequestMapping("/wishList")
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @GetMapping("/getList")
    public List<WishList> getList(){
        return wishListService.getList();
    }

    @PostMapping("/getById")
    public WishList getById(@PathVariable int id){
        return wishListService.getById(id);
    }

    @PostMapping("/getByName")
    public List<WishList> getByName(@PathVariable String name){
        return wishListService.getByName(name);
    }

    @PostMapping("/getByStatue")
    public List<WishList> getByStatue(@PathVariable boolean statue){
        return wishListService.getByStatue(statue);
    }

    @PutMapping("/update")
    public int update(@PathVariable WishList wishList){
        return wishListService.updateWishList(wishList);
    }

    @PostMapping("/insert")
    public int insert(@PathVariable WishList wishList){
        return wishListService.insertWishList(wishList);
    }

}
