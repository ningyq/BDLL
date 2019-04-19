package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.util.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BooksMapper extends BaseMapper<Books> {
    @Select("select * from books where del_flag = 0")
    List<Books> selectList();

    @Select("select * from books where del_flag = 0 and name like concat('%', #{name}, '%')")
    List<Books> selectByName(String name);

    @Select("select * from books where del_flag = 0 and classify_id = #{classifyId}")
    List<Books> selectByClassify(int classifyId);

    @Select("select * from books where del_flag = 0 and status = #{status}")
    List<Books> selectByStatue(boolean status);

    @Select("select * from books where del_flag = 0 and id = #{id}")
    Books selectById(int id);

    @Update("update books set classify_id = 1 where classify_id = #{classifyId}")
    int updateClassify(int classifyId);
}