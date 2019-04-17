package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.beetl.sql.core.engine.PageQuery;


@Mapper
public interface BooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
    @Select("select * from books where del_flag = 1")
    PageQuery<Books> selectList();

    @Select("select * from books where del_flag = 1 and name like #name#")
    PageQuery<Books> selectByName(String name);
    @Select("select * from books where del_flag = 1 and classify_id like #classifyId#")
    PageQuery<Books> selectByClassify(int classifyId);
    @Select("select * from books where del_flag = 1 and statue like #statue#")
    PageQuery<Books> selectByStatue(boolean statue);
}