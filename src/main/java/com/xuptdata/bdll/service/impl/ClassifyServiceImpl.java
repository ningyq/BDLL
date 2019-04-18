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
    public PageInfo getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Classify> classifyList = classifyMapper.selectByDelFlag(0);
        PageInfo<Classify> pageInfo = new PageInfo<>(classifyList);
        return pageInfo;
    }

    @Override
    public Classify getById(int id) {
        Classify classify = classifyMapper.selectByPrimaryKey(id);
        if (classify.getDelFlag() == false) {
            return classify;
        } else {
            return null;
        }
    }

    @Override
    public Classify getByName(String name) {
        return classifyMapper.selectByName(name);
    }

    @Override
    public PageInfo getByStatue(boolean statue, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Classify> classifyList = classifyMapper.selectByStatue(statue);
        PageInfo<Classify> pageInfo = new PageInfo<>(classifyList);
        return pageInfo;
    }

    @Override
    @Transactional
    public int insertClassify(Classify classify) {
        return classifyMapper.insert(classify);
    }

    @Override
    @Transactional
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
    @Transactional
    public int updateClassify(Classify classify) {
        return classifyMapper.updateByPrimaryKey(classify);
    }
}
