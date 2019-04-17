package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WishListMapper extends BaseMapper<WishList> {
    @Select("select * from wish_list where del_flag = 0")
    List<WishList> selectAll();

    @Select("select * from wish_list where del_flag = 0 and name like #name#")
    List<WishList> getByName(String name);

    @Select("select * from wish_list where del_flag = 0 and statue = #statue ")
    List<WishList> getByStatue(int statue);
}