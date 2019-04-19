package com.xuptdata.bdll.service;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Classify;

import java.util.List;

public interface ClassifyService {
    PageInfo getList(int pageNum, int pageSize);

    Classify getById(int id);

    List<Classify> getByName(String name);

    int insertClassify(Classify classify);

    int updateClassify(Classify classify);
}
