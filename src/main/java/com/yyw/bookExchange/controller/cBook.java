package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.ReturnWrap;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Result;
import org.springframework.web.bind.annotation.*;

/**
 * book service
 * @author frank
 *
 * */

@RestController
public class cBook {

    final BookDao dao;

    public cBook(BookDao dao) {
        this.dao = dao;
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
}
