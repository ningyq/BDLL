package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
    @GetMapping("/list")
    public PageInfo getList(@PathVariable int pageNum, @PathVariable  int pageSize){
        return classifyService.getList(pageNum, pageSize);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public Result getById(@PathVariable int id){
        Classify classify = classifyService.getById(id);
        return new Result("success","查找成功", classify);
    }

    /**
     * 根据分类名查询
     * @param name
     * @return
     */
    @GetMapping("/name")
    public Result getByName(@PathVariable String name){
        Classify classify = classifyService.getByName(name);
        return new Result("success","查找成功", classify);
    }

    /**
     * 根据状态查询
     * @param statue
     * @return
     */
    @GetMapping("/statue")
    public Result getByStatue(@PathVariable boolean statue, @PathVariable  int pageNum, @PathVariable  int pageSize){
        PageInfo<Classify> page =  classifyService.getByStatue(statue, pageNum, pageSize);
        return new Result("success","查找成功", page);
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

    /**
     * 根据编号删除
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        int result =  classifyService.deleteClassifyId(id);
        if (result == 0){
            return new Result("error","删除失败");
        }
        return new Result("success","删除成功");
    }
}
