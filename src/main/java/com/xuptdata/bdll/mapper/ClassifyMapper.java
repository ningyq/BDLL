package com.xuptdata.bdll.mapper;

import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.util.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassifyMapper extends BaseMapper<Classify> {
    @Select("select * from classify where del_flag = 0 and name like #name#")
    Classify selectByName(String name);

    @Select("select * from classify where del_flag = 0 and statue like #statue#")
    List<Classify> selectByStatue(boolean statue);

    @Select("select * from classify where del_flag = #delFlag#")
    List<Classify> selectByDelFlag(int delFlag);
}