package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.service.BooksService;
import com.xuptdata.bdll.service.WishListService;
import com.xuptdata.bdll.service.impl.BooksServiceImpl;
import com.xuptdata.bdll.service.impl.WishListServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 18:18
 */
@Controller
@RequestMapping("/wishList")
public class WishListController {
    @Autowired
    private WishListServiceImpl wishListService;
    @Autowired
    private BooksServiceImpl booksService;

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
    public List<WishList> getByStatue(@PathVariable int statue){
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
    @PostMapping("/update/statue")
    public int updateStatue(@PathVariable int statue,@PathVariable int id){
        WishList wishList = wishListService.getById(id);
        if (statue == 0){
            wishList.setStatus(1);
        }
        if (statue == 1){
            wishList.setStatus(2);
            wishList.setDelFlag(true);
            Books books = new Books();
            books.setName(wishList.getName());
            books.setClassifyId(wishList.getClassifyId());
            books.setStatus(true);
            booksService.insertBook(books);
        }
        return wishListService.updateWishList(wishList);

    }

}
