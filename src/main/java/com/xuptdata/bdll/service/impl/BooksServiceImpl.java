package com.xuptdata.bdll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Books> ret = booksMapper.selectList();
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    public Books getById(int id) {
        Books ret  = booksMapper.selectByPrimaryKey(id);
        return ret;
    }

    @Override
    public List<Books> getByName(String name) {
        List<Books> ret = booksMapper.selectByName(name);
        return ret;
    }

    @Override
    public PageInfo getByClassify(int pageNum, int pageSize,int classifyId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Books> ret = booksMapper.selectByClassify(classifyId);
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    public PageInfo getByStatue(int pageNum, int pageSize,boolean statue) {
        PageHelper.startPage(pageNum,pageSize);
        List<Books> ret = booksMapper.selectByStatue(statue);
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
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
