package com.xuptdata.bdll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.mapper.WishListMapper;
import com.xuptdata.bdll.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 11:17
 */
@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    private WishListMapper wishListMapper;

    @Override
    public PageInfo getList(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<WishList> ret = wishListMapper.selectAll();
        PageInfo<WishList> pageInfo = new PageInfo<>(ret);
        return pageInfo;

    }
    @Override
    public WishList getById(int id) {
        WishList ret = wishListMapper.selectByPrimaryKey(id);
        return ret;
    }

    @Override
    public List<WishList> getByName(String name) {
        List<WishList> ret = wishListMapper.getByName(name);
        return ret;
    }

    @Override
    public PageInfo getByClassify(int pageNum, int pageSize, int classifyId) {
        PageHelper.startPage(pageNum,pageSize);
        List<WishList> ret = wishListMapper.getByClassify(classifyId);
        PageInfo<WishList> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }

    @Override
    @Transactional
    public int insertWishList(WishList wishList) {
        return wishListMapper.insert(wishList);
    }

    @Override
    @Transactional
    public int updateWishList(WishList wishList) {
        return wishListMapper.updateByPrimaryKey(wishList);
    }

    @Override
    public PageInfo getByStatue(int pageNum,int pageSize,int statue) {
        PageHelper.startPage(pageNum,pageSize);
        List<WishList> ret = wishListMapper.getByStatue(statue);
        PageInfo<WishList> pageInfo = new PageInfo<>(ret);
        return pageInfo;
    }
}
