package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.service.impl.BooksServiceImpl;
import com.xuptdata.bdll.service.impl.WishListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public Result getList(@PathVariable int pageNum, @PathVariable int pageSize){
        PageInfo pageInfo =  wishListService.getList(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result getById(@PathVariable int id){
        WishList wishList =  wishListService.getById(id);
        return new Result("success","查询成功",wishList);
    }

    /**
     * 根据书名查询
     * @param name
     * @return
     */
    @GetMapping("/getByName")
    public Result getByName(@PathVariable String name){
        List<WishList> wishListList =  wishListService.getByName(name);
        return new Result("success","查询成功",wishListList);
    }


    /**
     * 根据心愿单状态查询
     * @param statue
     * @return
     */
    @GetMapping("/getByStatue")
    public Result getByStatue(@PathVariable int pageNum, @PathVariable int pageSize,@PathVariable int statue){
        PageInfo pageInfo =  wishListService.getByStatue(pageNum,pageSize,statue);
        return new Result("success","查询成功",pageInfo);
    }


    @GetMapping("/getByClassifyId")
    public Result getByClassify(@PathVariable int pageNum, @PathVariable int pageSize,@PathVariable int classigyId){
        PageInfo pageInfo = wishListService.getByClassify(pageNum,pageSize,classigyId);
        return new Result("success","查询成功",pageInfo);
    }

    /**
     * 修改信息
     * @param wishList
     * @return
     */
    @PutMapping("/update")
    public Result update(@PathVariable WishList wishList){
        int result =  wishListService.updateWishList(wishList);
        if (result == 0){
            return new Result("error","更新失败");
        }
        return new Result("success","更新成功");
    }

    /**
     * 添加心愿单
     * @param wishList
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@PathVariable WishList wishList){
        wishList.setCreateTime(new Date());
        int result =  wishListService.insertWishList(wishList);
        if (result == 0){
            return new Result("error","添加失败");
        }
        return new Result("success","添加成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public Result deleteWish(@PathVariable int id){
        WishList wishList = wishListService.getById(id);
        wishList.setDelFlag(true);
        int result = wishListService.updateWishList(wishList);
        if (result == 0){
            return new Result("error","删除失败");
        }
        return new Result("success","删除成功");

    }

    /**
     * 修改心愿单状态
     * @param statue
     * @param id
     * @return
     */
    @PostMapping("/update/statue")
    public Result updateStatue(@PathVariable int statue, @PathVariable int id){
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
                return new Result("error","添加失败");
            }
        }
        int result = wishListService.updateWishList(wishList);
        if (result == 0){
            return new Result("error","更新失败");
        }
        return new Result("success","更新成功");
    }
}
