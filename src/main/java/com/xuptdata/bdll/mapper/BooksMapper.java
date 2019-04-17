package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface BooksMapper extends BaseMapper<Books> {
    @Select("select * from books where del_flag = 1")
    List<Books> selectList();

    @Select("select * from books where del_flag = 1 and name like #name#")
    Books selectByName(String name);
    @Select("select * from books where del_flag = 1 and classify_id like #classifyId#")
    List<Books> selectByClassify(int classifyId);
    @Select("select * from books where del_flag = 1 and statue like #statue#")
    List<Books> selectByStatue(boolean statue);
}