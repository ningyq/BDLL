package com.xuptdata.bdll.controller;

import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: ningyq
 * @Date: 2019/4/18 11:52
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping("/getList")
    public List<Classify> getList(){
        return classifyService.getList();
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public Classify getById(@PathVariable int id){
        return classifyService.getById(id);
    }

    /**
     * 根据分类名查询
     * @param name
     * @return
     */
    @GetMapping("/getByName")
    public Classify getByName(@PathVariable String name){
        return classifyService.getByName(name);
    }

    /**
     * 根据状态查询
     * @param statue
     * @return
     */
    @GetMapping("/getByStatue")
    public List<Classify> getByStatue(@PathVariable boolean statue){
        return classifyService.getByStatue(statue);
    }

    /**
     * 更新分类
     * @param classify
     * @return
     */
    @PostMapping("/update")
    public Result update(@PathVariable Classify classify){
        int result = classifyService.updateClassify(classify);
        if (result == 0){
            return new Result("error","更新失败");
        }
        return new Result("success","更新成功");
    }

    /**
     * 增加分类
     * @param classify
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@PathVariable Classify classify){
        classify.setCreateTime(new Date());
        int result =  classifyService.insertClassify(classify);
        if (result == 0){
            return new Result("error","添加失败");
        }
        return new Result("success","添加成功");
    }
}
