package com.xuptdata.bdll.service;

import com.xuptdata.bdll.entity.WishList;
import org.beetl.sql.core.engine.PageQuery;

/**
 * @Author: slicing
 * @Date: 2019/4/17 11:12
 */
public interface WishListService {
    PageQuery<WishList> getList();
    WishList getByName(String name);
    int insertWishList(WishList wishList);
    int deleteWishList(int id);
    int updateWishList(WishList wishList);
    PageQuery<WishList> getByStatue(boolean statue);
}
