package com.xuptdata.bdll.service.impl;

import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.mapper.WishListMapper;
import com.xuptdata.bdll.service.WishListService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: slicing
 * @Date: 2019/4/17 11:17
 */
@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    private WishListMapper wishListMapper;
    @Override
    public PageQuery<WishList> getList() {
        PageQuery<WishList> ret = wishListMapper.selectAll();
        return ret;
    }

    @Override
    public WishList getByName(String name) {
        WishList ret = wishListMapper.getByName(name);
        return ret;
    }

    @Override
    public int insertWishList(WishList wishList) {
        return wishListMapper.insert(wishList);
    }

    @Override
    public int deleteWishList(int id) {
        return wishListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateWishList(WishList wishList) {
        return wishListMapper.updateByPrimaryKey(wishList);
    }

    @Override
    public PageQuery<WishList> getByStatue(boolean statue) {
        PageQuery<WishList> ret = wishListMapper.getByStatue(statue);
        return ret;
    }
}
