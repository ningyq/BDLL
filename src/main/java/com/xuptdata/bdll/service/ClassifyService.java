package com.xuptdata.bdll.service;

import com.xuptdata.bdll.entity.Classify;

import java.util.List;

public interface ClassifyService {
    List<Classify> getList();

    Classify getById(int id);

    Classify getByName(String name);

    List<Classify> getByStatue(boolean statue);

    int insertClassify(Classify classify);

    int deleteClassifyId(int id);

    int updateClassify(Classify classify);
}
