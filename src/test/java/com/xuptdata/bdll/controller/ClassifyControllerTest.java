package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.mapper.ClassifyMapper;
import com.xuptdata.bdll.service.ClassifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: ningyq
 * @Date: 2019/4/19 15:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassifyControllerTest {
    @Autowired
    private ClassifyMapper classifyMapper;

    @Test
    public void getList() {
        List<Classify> classifyList = classifyMapper.selectList();

        System.out.println(classifyList);
    }
}