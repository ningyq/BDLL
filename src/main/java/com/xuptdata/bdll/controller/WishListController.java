package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.Response;
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

    /**
     * 查询所有心愿单信息
     * @return
     */
    @GetMapping("/getList")
    public List<WishList> getList(){
        return wishListService.getList();
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public WishList getById(@PathVariable int id){
        return wishListService.getById(id);
    }

    /**
     * 根据书名查询
     * @param name
     * @return
     */
    @GetMapping("/getByName")
    public List<WishList> getByName(@PathVariable String name){
        return wishListService.getByName(name);
    }


    /**
     * 根据心愿单状态查询
     * @param statue
     * @return
     */
    @GetMapping("/getByStatue")
    public List<WishList> getByStatue(@PathVariable int statue){
        return wishListService.getByStatue(statue);
    }

    /**
     * 修改信息
     * @param wishList
     * @return
     */
    @PutMapping("/update")
    public Response update(@PathVariable WishList wishList){
        int result =  wishListService.updateWishList(wishList);
        if (result == 0){
            return new Response("error","更新失败");
        }
        return new Response("success","更新成功");
    }

    /**
     * 添加心愿单
     * @param wishList
     * @return
     */
    @PostMapping("/insert")
    public Response insert(@PathVariable WishList wishList){
        wishList.setCreateTime(new Date());
        int result =  wishListService.insertWishList(wishList);
        if (result == 0){
            return new Response("error","添加失败");
        }
        return new Response("success","添加成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public Response deleteWish(@PathVariable int id){
        WishList wishList = wishListService.getById(id);
        wishList.setDelFlag(true);
        int result = wishListService.updateWishList(wishList);
        if (result == 0){
            return new Response("error","删除失败");
        }
        return new Response("success","删除成功");

    }

    /**
     * 修改心愿单状态
     * @param statue
     * @param id
     * @return
     */
    @PostMapping("/update/statue")
    public Response updateStatue(@PathVariable int statue,@PathVariable int id){
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
            int result = booksService.insertBook(books);
            if (result == 0){
                return new Response("error","添加失败");
            }
            return new Response("success","添加成功");
        }
        int result = wishListService.updateWishList(wishList);
        if (result == 0){
            return new Response("error","更新失败");
        }
        return new Response("success","更新成功");

    }

}
