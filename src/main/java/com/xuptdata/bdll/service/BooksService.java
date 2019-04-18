package com.xuptdata.bdll.service;


import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Books;

import java.util.List;


/**
 * @Author: slicing
 * @Date: 2019/4/16 17:40
 */
public interface BooksService {
    PageInfo getList(int pageNum, int pageSize);

    Books getById(int id);

    List<Books> getByName(String name);

    PageInfo getByClassify(int pageNum,int pageSize,int classifyId);

    PageInfo getByStatue(int pageNum,int pageSize,boolean statue);

    int insertBook(Books book);

    int updateBooks(Books books);
}
