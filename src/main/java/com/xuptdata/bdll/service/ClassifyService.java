package com.xuptdata.bdll.service;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Classify;

import java.util.List;

public interface ClassifyService {
    PageInfo getList(int pageNum, int pageSize);

    Classify getById(int id);

    Classify getByName(String name);

    PageInfo getByStatue(boolean statue, int pageNum, int pageSize);

    int insertClassify(Classify classify);

    int deleteClassifyId(int id);

    int updateClassify(Classify classify);
}
