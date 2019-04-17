package com.xuptdata.bdll.service.impl;

import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.mapper.ClassifyMapper;
import com.xuptdata.bdll.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public List<Classify> getList() {
        return classifyMapper.selectAll();
    }

    @Override
    public Classify getById(int id) {
        return classifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Classify getByName(String name) {
        return classifyMapper.selectByName(name);
    }

    @Override
    public List<Classify> getByStatue(boolean statue) {
        return classifyMapper.selectByStatue(statue);
    }

    @Override
    public int insertClassify(Classify classify) {
        return classifyMapper.insert(classify);
    }

    @Override
    public int deleteClassifyId(int id) {
        Classify classify = getById(id);
        if (classify == null) {
            return 0;
        } else {
            classify.setDelFlag(true);
            return 1;
        }
    }

    @Override
    public int updateClassify(Classify classify) {
        return classifyMapper.updateByPrimaryKey(classify);
    }
}
