package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.CommentDao;
import com.yyw.bookExchange.dao.ReturnWrap;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Comment;
import com.yyw.bookExchange.data.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * book service
 * @author frank
 *
 * */

@RestController
public class CBook {

    private final BookDao dao;
    private final CommentDao cdao;

    public CBook(BookDao dao, CommentDao cdao) {
        this.dao = dao;
        this.cdao = cdao;
    }

    @PostMapping("/book")
    public Result Add(@RequestBody Book b){
        dao.save(b);
        return new Result(0,"success");
    }

    @DeleteMapping("/book/{id}")
    public Result Delete(@PathVariable Long id){
        dao.deleteById(id);
        return new Result(0,"success");
    }

    @GetMapping("/book/{id}")
    public Book Get(@PathVariable Long id){
        return dao.getOne(id);
    }

    @PutMapping("/book")
    public Result Modify(@RequestBody Book b){
        dao.deleteById(b.getPid());
        dao.save(b);
        return new Result(0,"success");
    }

    @PutMapping("/book/{id}/loveadd")
    public ReturnWrap Modify(@PathVariable long id){
        Book b = dao.getOne(id);
        b.setLove(b.getLove()+1);
        dao.deleteById(id);
        dao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/book/{id}/comment")
    public ReturnWrap GetComment(@PathVariable long id){
        List<Comment> c =  cdao.findAll();
        c = c.stream().filter(b -> b.getBookId() == id).collect(Collectors.toList());
        return ReturnWrap.returnWithData(c);
    }
}
