package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.service.BooksService;
import com.xuptdata.bdll.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 18:18
 */
@RestController
@RequestMapping("/wishList")
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @Autowired
    private BooksService booksService;

    /**
     * 查询所有心愿单信息
     * @return
     */
    @GetMapping("/list")
    public Result getList(int pageNum, int pageSize){
        PageInfo pageInfo =  wishListService.getList(pageNum, pageSize);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getById(int id){
        WishList wishList =  wishListService.getById(id);
        return new Result("success", "查询成功", wishList);
    }

    /**
     * 根据书名查询
     * @param name
     * @return
     */
    @GetMapping("/name")
    public Result getByName(String name){
        List<WishList> wishListList =  wishListService.getByName(name);
        return new Result("success", "查询成功", wishListList);
    }


    /**
     * 根据心愿单状态查询
     * @param status
     * @return
     */
    @GetMapping("/status")
    public Result getByStatue(int pageNum, int pageSize, int status){
        PageInfo pageInfo =  wishListService.getByStatus(pageNum, pageSize, status);
        return new Result("success", "查询成功", pageInfo);
    }


    @GetMapping("/classifyId")
    public Result getByClassify(int pageNum, int pageSize, int classifyId){
        PageInfo pageInfo = wishListService.getByClassify(pageNum, pageSize, classifyId);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 修改信息
     * @param wishList
     * @return
     */
    @PutMapping("/update")
    public Result update(WishList wishList){
        int result =  wishListService.updateWishList(wishList);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }

    /**
     * 添加心愿单
     * @param wishList
     * @return
     */
    @PostMapping("/insert")
    public Result insert(WishList wishList){
        int result =  wishListService.insertWishList(wishList);
        if (result == 0){
            return new Result("error", "添加失败");
        }
        return new Result("success", "添加成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public Result deleteWish(int id){
        WishList wishList = new WishList();
        wishList.setId(id);
        wishList.setDelFlag(true);
        int result = wishListService.updateWishList(wishList);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");

    }

    /**
     * 修改心愿单状态
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/update/status")
    public Result updateStatus(int status, int id){
        WishList wishList = new WishList();
        wishList.setId(id);
        if (status == 0){
            wishList.setStatus(1);
        }
        if (status == 1){
            wishList.setStatus(2);
            wishList.setDelFlag(true);
            Books books = new Books();
            books.setName(wishList.getName());
            books.setClassifyId(wishList.getClassifyId());
            books.setStatus(true);
            int result = booksService.insertBook(books);
            if (result == 0){
                return new Result("error", "添加失败");
            }
        }
        int result = wishListService.updateWishList(wishList);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }
}
