package com.yyw.bookExchange.controller;


import com.yyw.bookExchange.dao.CommentDao;
import com.yyw.bookExchange.dao.ReturnWrap;
import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Result;
import com.yyw.bookExchange.data.Text;
import com.yyw.bookExchange.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Comment {

    CommentDao dao;

    @Autowired
    public Comment(CommentDao dao) {
        this.dao = dao;
    }

    @PostMapping("/comment")
    public ReturnWrap Create(Text u){
        dao.save(u);
        return ReturnWrap.SUCCEED;
    }


    @DeleteMapping("/comment/{id}")
    public ReturnWrap Delete(@PathVariable Long id){
        dao.deleteById(id);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/comment/{id}")
    public ReturnWrap Query(@PathVariable Long id){
        return ReturnWrap.returnWithData(dao.findById(id));
    }

    @PutMapping("/comment/{id}")
    public ReturnWrap Update(@PathVariable Long id,@RequestBody Text u){
        dao.deleteById(id);
        dao.save(u);
        return ReturnWrap.returnWithData(u);
    }
}
