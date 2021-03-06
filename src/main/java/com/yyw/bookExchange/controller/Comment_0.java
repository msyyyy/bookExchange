package com.yyw.bookExchange.controller;


import com.yyw.bookExchange.dao.CommentDao;
import com.yyw.bookExchange.data.Comment;
import com.yyw.bookExchange.data.ReturnWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yyw
 */
@RestController
public class Comment_0 {

    final private CommentDao dao;

    @Autowired
    public Comment_0(CommentDao dao) {
        this.dao = dao;
    }

    @PostMapping("/comment")
    public ReturnWrap Create(@RequestBody Comment u) {
        dao.save(u);
        return ReturnWrap.SUCCEED;
    }


    @DeleteMapping("/comment/{id}")
    public ReturnWrap Delete(@PathVariable Long id) {
        dao.deleteById(id);
        return ReturnWrap.SUCCEED;
    }


    @GetMapping("/comments")
    public ReturnWrap Query0() {
        return ReturnWrap.returnWithData(dao.findAll());
    }

    @GetMapping("/comment/{id}")
    public ReturnWrap Query(@PathVariable Long id) {
        return ReturnWrap.returnWithData(dao.findById(id));
    }

    @PutMapping("/comment/{id}")
    public ReturnWrap Update(@PathVariable Long id, @RequestBody com.yyw.bookExchange.data.Comment u) {
        dao.deleteById(id);
        dao.save(u);
        return ReturnWrap.returnWithData(u);
    }

    @PutMapping("/comment/evaluate")
    public ReturnWrap evaluate(@RequestBody com.yyw.bookExchange.data.Comment u, @RequestParam(value = "id") long id) {
        u.setId(id);
        dao.save(u);
        return ReturnWrap.returnWithData(u);
    }

}
