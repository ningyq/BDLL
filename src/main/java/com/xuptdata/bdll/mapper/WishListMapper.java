package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.WishList;
import com.xuptdata.bdll.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WishListMapper extends BaseMapper<WishList> {
    @Select("select * from wish_list where del_flag = 0")
    List<WishList> selectAll();

    @Select("select * from wish_list where del_flag = 0 and name like concat('%', #{name}, '%')")
    List<WishList> getByName(String name);

    @Select("select * from wish_list where del_flag = 0 and status = #{status}")
    List<WishList> getByStatue(int status);

    @Select("select * from wish_list where del_flag = 0 and classify_id = #{classifyId}")
    List<WishList> getByClassify(int classifyId);

    @Select("select * from wish_list where del_flag = 0 and id = #{id}")
    WishList selectById(int id);

    @Update("update wish_list set classify_id = 1 where classify_id = #{classifyId}")
    int updateClassify(int classifyId);
}