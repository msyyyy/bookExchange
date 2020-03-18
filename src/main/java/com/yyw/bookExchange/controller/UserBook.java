package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.common.Binary;
import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.ReturnWrap;
import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserBook {

    private final UserDao dao;

    private final BookDao bdao;

    @Autowired
    public UserBook(UserDao dao, BookDao bdao) {
        this.dao = dao;
        this.bdao = bdao;
    }

    @GetMapping("/user/{id}/lovebook")
    public ReturnWrap GetLoveBook(@PathVariable long id){
        long u = dao.getOne(id).getLove();
        List<Integer> l =  Binary.getBit(u);
        List<Book> b = new ArrayList<>();
        for (Integer integer : l) {
            b.add(bdao.getOne(integer.longValue()));
        }
        return ReturnWrap.returnWithData(b);
    }

    @GetMapping("/user/{id}/notlovebook")
    public ReturnWrap GetNotLoveBook(@PathVariable long id){
        long u = dao.getOne(id).getNotlove();
        List<Integer> l = Binary.getBit(u);
        List<Book> b = new ArrayList<>();
        for (Integer integer : l) {
            b.add(bdao.getOne(integer.longValue()));
        }
        return ReturnWrap.returnWithData(b);
    }

    @GetMapping("/user/{id}/savebook")
    public ReturnWrap GetSaveBook(@PathVariable long id){
        long u = dao.getOne(id).getSave();
        List<Integer> l =  Binary.getBit(u);
        List<Book> b = new ArrayList<>();
        for (Integer integer : l) {
            b.add(bdao.getOne(integer.longValue()));
        }
        return ReturnWrap.returnWithData(b);
    }
}
