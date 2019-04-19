package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.User;
import com.xuptdata.bdll.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where id = #{id}")
    User selectById(int id);
}