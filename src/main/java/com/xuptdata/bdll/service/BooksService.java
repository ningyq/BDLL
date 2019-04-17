package com.xuptdata.bdll.service;


import com.xuptdata.bdll.entity.Books;
import org.beetl.sql.core.engine.PageQuery;



/**
 * @Author: slicing
 * @Date: 2019/4/16 17:40
 */
public interface BooksService {
    PageQuery<Books> getList();

    Books getById(int id);

    PageQuery<Books> getByName(String name);

    PageQuery<Books> getByClassify(int classifyId);

    PageQuery<Books> getByStatue(boolean statue);

    int insertBook(Books book);
    int deleteBookById(int id);
    int updateBooks(Books books);


}
