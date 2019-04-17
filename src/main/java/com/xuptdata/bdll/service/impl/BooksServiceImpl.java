package com.xuptdata.bdll.service.impl;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.mapper.BooksMapper;
import com.xuptdata.bdll.service.BooksService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: slicing
 * @Date: 2019/4/16 17:41
 */
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;
    @Override
    public PageQuery<Books> getList() {
        PageQuery<Books> ret = booksMapper.selectList();
        return ret;
    }

    @Override
    public Books getById(int id) {
        Books ret  = booksMapper.selectByPrimaryKey(id);
        return ret;
    }

    @Override
    public PageQuery<Books> getByName(String name) {
        PageQuery<Books> ret = booksMapper.selectByName(name);
        return ret;
    }

    @Override
    public PageQuery<Books> getByClassify(int classifyId) {
        PageQuery<Books> ret = booksMapper.selectByClassify(classifyId);
        return ret;
    }

    @Override
    public PageQuery<Books> getByStatue(boolean statue) {
        PageQuery<Books> ret = booksMapper.selectByStatue(statue);
        return ret;
    }

    @Override
    public int insertBook(Books book) {
        return booksMapper.insert(book);
    }

    @Override
    public int deleteBookById(int id) {
        return booksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBooks(Books books) {
        return booksMapper.updateByPrimaryKey(books);
    }
}
