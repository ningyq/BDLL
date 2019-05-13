package com.xuptdata.bdll.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.mapper.ClassifyMapper;
import com.xuptdata.bdll.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public List<Classify> getAll() {
        return classifyMapper.selectList();
    }

    @Override
    public PageInfo getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Classify> classifyList = classifyMapper.selectList();
        PageInfo<Classify> pageInfo = new PageInfo<>(classifyList);
        return pageInfo;
    }

    @Override
    public Classify getById(int id) {
        return classifyMapper.selectById(id);
    }

    @Override
    public Classify getByName(String name) {
        return classifyMapper.selectByName(name);
    }

    @Override
    @Transactional
    public int insertClassify(Classify classify) {
        Classify classify1 = getByName(classify.getName());
        if (classify1 != null) {
            return -1;
        }
        return classifyMapper.insertSelective(classify);
    }

    @Override
    @Transactional
    public int updateClassify(Classify classify) {
        return classifyMapper.updateByPrimaryKeySelective(classify);
    }
}
