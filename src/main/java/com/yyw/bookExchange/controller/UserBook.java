package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.common.Binary;
import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.CommentDao;
import com.yyw.bookExchange.dao.ReturnWrap;
import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserBook {

    private final UserDao dao;

    private final BookDao bdao;

    private final CommentDao cdao;

    @Autowired
    public UserBook(UserDao dao, BookDao bdao, CommentDao cdao) {
        this.dao = dao;
        this.bdao = bdao;
        this.cdao = cdao;
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

    @GetMapping("/user/{id}/comment")
    public ReturnWrap GetComment(@PathVariable long id){
        List<Comment> c =  cdao.findAll();
        c = c.stream().filter(b -> b.getUserId() == id).collect(Collectors.toList());
        return ReturnWrap.returnWithData(c);
    }


}
