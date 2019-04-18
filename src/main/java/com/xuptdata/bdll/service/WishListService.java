package com.xuptdata.bdll.service;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.WishList;


import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/17 11:12
 */
public interface WishListService {
    PageInfo getList(int pageNum, int pageSize);

    WishList getById(int id);

    List<WishList> getByName(String name);

    PageInfo getByClassify(int pageNum,int pageSize,int classifyId);

    int insertWishList(WishList wishList);

    int deleteWishList(int id);

    int updateWishList(WishList wishList);

    PageInfo getByStatue(int pageNum,int pageSize,int statue);
}
