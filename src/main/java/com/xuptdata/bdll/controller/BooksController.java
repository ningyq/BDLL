package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.service.impl.BooksServiceImpl;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public PageQuery<Books> getList(){
        PageQuery<Books> ret = booksService.getList();
        return ret;
    }


}
