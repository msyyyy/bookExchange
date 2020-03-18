package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.common.Binary;
import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.CommentDao;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Comment;
import com.yyw.bookExchange.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yyw
 */
@RestController
public class UserBook {

    private final UserDao userDao;

    private final BookDao bookDao;

    private final CBook cBook;

    private final CommentDao commentDao;

    @Autowired
    public UserBook(UserDao dao, BookDao bdao, CBook cBook, CommentDao cdao) {
        this.userDao = dao;
        this.bookDao = bdao;
        this.cBook = cBook;
        this.commentDao = cdao;
    }

    @GetMapping("/user/{id}/lovebook")
    public ReturnWrap GetLoveBook(@PathVariable long id){
        long u = userDao.getOne(id).getLove();
        return ReturnWrap.returnWithData(getBookByCondition(u));
    }

    @GetMapping("/user/{id}/notlovebook")
    public ReturnWrap GetNotLoveBook(@PathVariable long id){
        long u = userDao.getOne(id).getNotlove();
        return ReturnWrap.returnWithData(getBookByCondition(u));
    }

    @GetMapping("/user/{id}/savebook")
    public ReturnWrap getSaveBook(@PathVariable long id){
        long u = userDao.getOne(id).getSave();
        return ReturnWrap.returnWithData(getBookByCondition(u));
    }

    private List<Book> getBookByCondition(long u) {
        List<Integer> l = Binary.getBit(u);
        List<Book> b = new ArrayList<>();
        for (Integer integer : l) {
            b.add(bookDao.getOne(integer.longValue()));
        }
        return b;
    }

    @PutMapping("/user/{id}/notlovebook/{bid}")
    public ReturnWrap SetNotLoveBook(@PathVariable long id,@PathVariable long bid){
        User u = userDao.getOne(id);
        u.setNotlove(u.getNotlove()|(1 << bid));
        userDao.save(u);
        cBook.notLoveAdd(bid);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/user/{id}/savebook/{bid}")
    public ReturnWrap SetSaveBook(@PathVariable long id,@PathVariable long bid){
        User u = userDao.getOne(id);
        u.setSave(u.getSave()|(1 << bid));
        userDao.save(u);
        cBook.saveAdd(bid);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/user/{id}/lovebook/{bid}")
    public ReturnWrap setLoveBook(@PathVariable long id, @PathVariable long bid){
        User u = userDao.getOne(id);
        u.setLove(u.getLove()|(1 << bid));
        userDao.save(u);
        cBook.loveAdd(bid);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/user/{id}/comment")
    public ReturnWrap GetComment(@PathVariable long id){
        List<Comment> c =  commentDao.findAll();
        c = c.stream().filter(b -> b.getUserId() == id).collect(Collectors.toList());
        return ReturnWrap.returnWithData(c);
    }
}
