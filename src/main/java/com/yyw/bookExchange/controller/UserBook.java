package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.common.Binary;
import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.ReturnWrap;
import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Result;
import com.yyw.bookExchange.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserBook {

    @Autowired
    UserDao dao;

    @Autowired
    BookDao bdao;

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
}
