package com.xuptdata.bdll.service;

import com.xuptdata.bdll.entity.WishList;


import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 11:12
 */
public interface WishListService {
    List<WishList> getList();
    WishList getById(int id);
    List<WishList> getByName(String name);
    int insertWishList(WishList wishList);
    int deleteWishList(int id);
    int updateWishList(WishList wishList);
    List<WishList> getByStatue(boolean statue);
}
