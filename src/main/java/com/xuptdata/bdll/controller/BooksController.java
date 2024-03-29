package com.xuptdata.bdll.controller;

import com.github.pagehelper.PageInfo;
import com.xuptdata.bdll.entity.Books;
import com.xuptdata.bdll.entity.Result;
import com.xuptdata.bdll.service.BooksService;
import com.xuptdata.bdll.utils.FtpUtil;
import com.xuptdata.bdll.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: slicing
 * @Date: 2019/4/17 10:21
 */
@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    /**
     * 查询所有图书信息
     * @return
     */
    @GetMapping("/list")
    public Result getList(int pageNum, int pageSize){
        PageInfo pageInfo = booksService.getList(pageNum, pageSize);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getById(int id){
        Books books = booksService.getById(id);
        return new Result("success", "查询成功",books);
    }

    /**
     * 上传图书图片
     * @param id
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result uploadImg(int id, MultipartFile image) throws IOException {
        String url;
        String oldName = image.getOriginalFilename();
        String newName = UploadUtils.generateRandomFileName(oldName);
        String imageSavePath = "/book";

        url = FtpUtil.pictureUploadByConfig(newName, imageSavePath, image.getInputStream());
        if (url != null) {
            url = "http://image.xuptdata.com" + url;
            Books book = booksService.getById(id);
            book.setImgUrl(url);
            booksService.updateBooks(book);
            return new Result("success","上传成功!", url);
        }
        return new Result("error", "上传失败!");
    }

    /**
     * 根据书名查询
     * @param name
     * @return
     */
    @GetMapping("/name")
    public Result getByName(int pageNum, int pageSize, String name){
        PageInfo pageInfo = booksService.getByName(pageNum, pageSize, name);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据类别查询
     * @param classifyId
     * @return
     */
    @GetMapping("/classifyId")
    public Result getByClassifyId(int pageNum, int pageSize, int classifyId){
        PageInfo pageInfo = booksService.getByClassify(pageNum, pageSize, classifyId);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据状态查询
     * @param status
     * @return
     */
    @GetMapping("/status")
    public Result getByStatus(int pageNum, int pageSize, boolean status){
        PageInfo pageInfo =  booksService.getByStatus(pageNum, pageSize, status);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 修改
     * @param books
     * @return
     */
    @PutMapping("/update")
    public Result update(Books books){
        int result =  booksService.updateBooks(books);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }

    /**
     * 增加
     * @param books
     * @return
     */
    @PostMapping("/insert")
    public Result insert(Books books){
        int result =  booksService.insertBook(books);
        if (result == 0){
            return new Result("error", "添加失败");
        }
        return new Result("success", "添加成功");
    }

    /**
     * 借书
     * @param id
     * @return
     */

    @PutMapping("/update/borrow")
    public Result borrow(int id){
        Books books = booksService.getById(id);
        Books books1 = new Books();
        books1.setId(books.getId());
        if (books.getNumber() > 0){
            books1.setNumber(books.getNumber() - 1);
            if (books.getNumber() == 0){
                books1.setStatus(false);
            }
            int result = booksService.updateBooks(books1);
            if (result == 0){
                return new Result("error", "借阅失败");
            }
            return new Result("success", "借阅成功");
        }
        return new Result("error", "借阅失败，书籍无库存");
    }

    /**
     * 还书
     * @param id
     * @return
     */
    @PutMapping("/update/restitution")
    public Result restitution(int id){
        Books books = booksService.getById(id);
        Books books1 = new Books();
        books1.setId(id);
        books1.setNumber(books.getNumber() + 1);
        if (books.getNumber() == 1){
            books1.setStatus(true);
        }
        int result =  booksService.updateBooks(books1);
        if (result == 0){
            return new Result("error", "还书失败");
        }
        return new Result("success", "还书成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PutMapping("/delete")
    public Result delete(int id){
        Books books = new Books();
        books.setId(id);
        books.setDelFlag(true);
        int result =  booksService.updateBooks(books);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }
}
