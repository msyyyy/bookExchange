package com.yyw.bookExchange.controller;


import com.yyw.bookExchange.common.ListUtil;
import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.ReturnWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Comparator;
import java.util.List;

/**
 * @author yyw
 */
@RestController
public class BookRank {
    private final BookDao bookDao;

    @Autowired
    public BookRank(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @GetMapping("/bookrank/love")
    public ReturnWrap<List<Book>> getLoveWithOffset(@PathParam("offset") int offset, @PathParam("length") int length) {
        List<Book> books = bookDao.findAll();
        books.sort(Comparator.comparingInt(fn -> -fn.getLove()));
        return ListUtil.getByCondition(offset, length, books);
    }

    @GetMapping("/bookrank/notlove")
    public ReturnWrap<List<Book>> getNotLoveWithOffset(@PathParam("offset") int offset, @PathParam("length") int length) {
        List<Book> books = bookDao.findAll();
        books.sort(Comparator.comparingInt(fn -> -fn.getNotLove()));
        return ListUtil.getByCondition(offset, length, books);
    }

    @GetMapping("/bookrank/save")
    public ReturnWrap<List<Book>> getSaveWithOffset(@PathParam("offset") int offset, @PathParam("length") int length) {
        List<Book> books = bookDao.findAll();
        books.sort(Comparator.comparingInt(Book::getSave));
        return ListUtil.getByCondition(offset, length, books);
    }

}
