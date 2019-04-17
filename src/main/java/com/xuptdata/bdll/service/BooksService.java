package com.xuptdata.bdll.service;


import com.xuptdata.bdll.entity.Books;

import java.util.List;


/**
 * @Author: slicing
 * @Date: 2019/4/16 17:40
 */
public interface BooksService {
    List<Books> getList();

    Books getById(int id);

    Books getByName(String name);

    List<Books> getByClassify(int classifyId);

    List<Books> getByStatue(boolean statue);

    int insertBook(Books book);

    int deleteBookById(int id);

    int updateBooks(Books books);


}
