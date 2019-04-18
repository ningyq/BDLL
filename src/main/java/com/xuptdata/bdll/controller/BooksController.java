package com.xuptdata.bdll.controller;
import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.Response;
import com.xuptdata.bdll.service.impl.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 10:21
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksServiceImpl booksService;

    /**
     * 查询所有图书信息
     * @return
     */
    @GetMapping("/getList")
    public List<Books> getList(){
        List<Books> ret = booksService.getList();
        return ret;
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Books getById(@PathVariable int id){
        return booksService.getById(id);
    }

    /**
     * 根据书名查询
     * @param name
     * @return
     */
    @GetMapping("/getByName")
    public Books getByName(@PathVariable String name){
        return booksService.getByName(name);
    }

    /**
     * 根据类别查询
     * @param classifyId
     * @return
     */
    @GetMapping("/getByClassifyId")
    public List<Books> getByClassifyId(@PathVariable int classifyId){
        return booksService.getByClassify(classifyId);
    }

    /**
     * 根据状态查询
     * @param statue
     * @return
     */
    @GetMapping("/getByStatue")
    public List<Books> getByStatue(@PathVariable boolean statue){
        return booksService.getByStatue(statue);
    }

    /**
     * 修改
     * @param books
     * @return
     */
    @PutMapping("/update")
    public Response update(@PathVariable Books books){
        int result =  booksService.updateBooks(books);
        if (result == 0){
            return new Response("error","更新失败");
        }
        return new Response("success","更新成功");
    }

    /**
     * 增加
     * @param books
     * @return
     */
    @PostMapping("/insert")
    public Response insert(@PathVariable Books books){
        books.setCreateTime(new Date());
        int result =  booksService.insertBook(books);
        if (result == 0){
            return new Response("error","添加失败");
        }
        return new Response("success","添加成功");
    }

    /**
     * 借书
     * @param id
     * @return
     */
    @PutMapping("/update/borrow")
    public Response borrow(@PathVariable int id){
        Books books = booksService.getById(id);
        if (books.getNumber()>0){
            books.setNumber(books.getNumber()-1);
            if (books.getNumber() == 0){
                books.setStatus(false);
            }
            int result = booksService.updateBooks(books);
            if (result == 0){
                return new Response("error","借阅失败");
            }
            return new Response("success","借阅成功");
        }
        return new Response("error","借阅失败，书籍无库存");

    }

    /**
     * 还书
     * @param id
     * @return
     */

    @PutMapping("/update/restitution")
    public Response restitution(@PathVariable int id){
        Books books = booksService.getById(id);
        books.setNumber(books.getNumber()-1);
        if (books.getNumber() == 1){
            books.setStatus(true);
        }
        int result =  booksService.updateBooks(books);
        if (result == 0){
            return new Response("error","还书失败");
        }
        return new Response("success","还书成功");
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public Response deleteWish(@PathVariable int id){
        Books books = booksService.getById(id);
        books.setDelFlag(true);
        int result =  booksService.updateBooks(books);
        if (result == 0){
            return new Response("error","删除失败");
        }
        return new Response("success","删除成功");
    }



}
