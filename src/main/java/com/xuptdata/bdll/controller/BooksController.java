package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.service.impl.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getList")
    public List<Books> getList(){
        List<Books> ret = booksService.getList();
        return ret;
    }

    @PostMapping("/getById")
    public Books getById(@PathVariable int id){
        return booksService.getById(id);
    }

    @PostMapping("/getByName")
    public Books getByName(@PathVariable String name){
        return booksService.getByName(name);
    }

    @PostMapping("/getByClassifyId")
    public Books getByClassifyId(@PathVariable int classifyId){
        return booksService.getById(classifyId);
    }

    @PostMapping("/getByStatue")
    public List<Books> getByStatue(@PathVariable boolean statue){
        return booksService.getByStatue(statue);
    }

    @PutMapping("/update")
    public int update(@PathVariable Books books){
        return booksService.updateBooks(books);
    }
    @PostMapping("/insert")
    public int insert(@PathVariable Books books){
        return booksService.insertBook(books);
    }



}
