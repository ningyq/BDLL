package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.WishList;
import org.apache.ibatis.annotations.Select;
import org.beetl.sql.core.engine.PageQuery;

public interface WishListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WishList record);

    int insertSelective(WishList record);

    WishList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WishList record);

    int updateByPrimaryKey(WishList record);

    @Select("select * from wish_list where del_flag = 0")
    PageQuery<WishList> selectAll();

    @Select("select * from wish_list where del_flag = 0 and name like #name#")
    WishList getByName(String name);

    @Select("select * from wish_list where del_flag = 0 and statue = #statue ")
    PageQuery<WishList> getByStatue(boolean statue);
}