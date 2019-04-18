package com.xuptdata.bdll.service.impl;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.mapper.BooksMapper;
import com.xuptdata.bdll.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/16 17:41
 */
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksMapper booksMapper;

    @Override
    public List<Books> getList() {
        List<Books> ret = booksMapper.selectList();
        return ret;
    }

    @Override
    public Books getById(int id) {
        Books ret  = booksMapper.selectByPrimaryKey(id);
        return ret;
    }

    @Override
    public Books getByName(String name) {
        Books ret = booksMapper.selectByName(name);
        return ret;
    }

    @Override
    public List<Books> getByClassify(int classifyId) {
        List<Books> ret = booksMapper.selectByClassify(classifyId);
        return ret;
    }

    @Override
    public List<Books> getByStatue(boolean statue) {
        List<Books> ret = booksMapper.selectByStatue(statue);
        return ret;
    }

    @Override
    @Transactional
    public int insertBook(Books book) {
        return booksMapper.insert(book);
    }

    @Override
    @Transactional
    public int deleteBookById(int id) {
        return booksMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateBooks(Books books) {
        return booksMapper.updateByPrimaryKey(books);
    }
}
