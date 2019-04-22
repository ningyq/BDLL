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
        PageHelper.startPage(pageNum, pageSize);
        List<Books> ret = booksMapper.selectList();
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    public Books getById(int id) {
        Books ret  = booksMapper.selectById(id);
        return ret;
    }

    @Override
    public PageInfo getByName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<Books> ret = booksMapper.selectByName(name);
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    @Transactional
    public int updateByClassifyId(int classifyId) {
        return booksMapper.updateClassify(classifyId);
    }

    @Override
    public PageInfo getByClassify(int pageNum, int pageSize, int classifyId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Books> ret = booksMapper.selectByClassify(classifyId);
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    public PageInfo getByStatus(int pageNum, int pageSize, boolean status) {
        PageHelper.startPage(pageNum, pageSize);
        List<Books> ret = booksMapper.selectByStatue(status);
        PageInfo<Books> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    @Transactional
    public int insertBook(Books book) {
        return booksMapper.insertSelective(book);
    }

    @Override
    @Transactional
    public int updateBooks(Books books) {
        return booksMapper.updateByPrimaryKeySelective(books);
    }
}
