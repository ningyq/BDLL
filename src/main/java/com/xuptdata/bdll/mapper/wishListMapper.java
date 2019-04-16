package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.wishList;

public interface wishListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(wishList record);

    int insertSelective(wishList record);

    wishList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(wishList record);

    int updateByPrimaryKey(wishList record);
}