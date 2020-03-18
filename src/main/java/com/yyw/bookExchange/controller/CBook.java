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

    private final BookDao bookDao;
    private final CommentDao commentDao;

    public CBook(BookDao dao, CommentDao cdao) {
        this.bookDao = dao;
        this.commentDao = cdao;
    }

    @PostMapping("/book")
    public ReturnWrap Add(@RequestBody Book b){
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @DeleteMapping("/book/{id}")
    public ReturnWrap Delete(@PathVariable Long id){
        bookDao.deleteById(id);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/book/{id}")
    public Book Get(@PathVariable Long id){
        return bookDao.getOne(id);
    }

    @PutMapping("/book")
    public Result Modify(@RequestBody Book b){
        bookDao.deleteById(b.getPid());
        bookDao.save(b);
        return new Result(0,"success");
    }

    @PutMapping("/book/{id}/loveadd")
    public ReturnWrap loveAdd(@PathVariable long id){
        Book b = bookDao.getOne(id);
        b.setLove(b.getLove()+1);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/book/{id}/notloveadd")
    public ReturnWrap notLoveAdd(@PathVariable long id){
        Book b = bookDao.getOne(id);
        b.setNotLove(b.getNotLove()+1);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }


    @PutMapping("/book/{id}/saveadd")
    public ReturnWrap saveAdd(@PathVariable long id){
        Book b = bookDao.getOne(id);
        b.setSave(b.getSave()+1);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/book/{id}/comment")
    public ReturnWrap GetComment(@PathVariable long id){
        List<Comment> c =  commentDao.findAll();
        c = c.stream().filter(b -> b.getBookId() == id).collect(Collectors.toList());
        return ReturnWrap.returnWithData(c);
    }
}
