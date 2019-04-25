package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Classify;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.service.BooksService;
import com.xuptdata.bdll.service.ClassifyService;
import com.xuptdata.bdll.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private BooksService booksService;

    @Autowired
    private WishListService wishListService;

    @GetMapping("/all")
    public List<Classify> getAll() {
        return classifyService.getAll();
    }

    /**
     * 查询所有分类(分页）
     * @return
     */
    @GetMapping("/list")
    public Result getList(int pageNum, int pageSize){
        PageInfo pageInfo = classifyService.getList(pageNum, pageSize);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getById(int id){
        Classify classify = classifyService.getById(id);
        return new Result("success", "查找成功", classify);
    }

    /**
     * 根据分类名查询
     * @param name
     * @return
     */
    @GetMapping("/name")
    public Result getByName(String name){
        Classify classifyList = classifyService.getByName(name);
        return new Result("success", "查找成功", classifyList);
    }

    /**
     * 更新分类
     * @param classify
     * @return
     */
    @PutMapping("/update")
    public Result update(Classify classify){
        int result = classifyService.updateClassify(classify);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }

    /**
     * 增加分类
     * @param classify
     * @return
     */
    @PostMapping("/insert")
    public Result insert(Classify classify){
        int result =  classifyService.insertClassify(classify);
        if (result == 0){
            return new Result("error", "添加失败");
        } else if (result == -1) {
            return new Result("error", "分类已存在");
        }
        return new Result("success", "添加成功");
    }

    /**
     * 根据编号删除
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public Result delete(int id){
        Classify classify = new Classify();
        classify.setId(id);
        classify.setDelFlag(true);
        int result =  classifyService.updateClassify(classify);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        booksService.updateByClassifyId(id);
        wishListService.updateByClassifyId(id);
        return new Result("success", "删除成功");
    }
}
