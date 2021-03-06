package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.dao.BookDao;
import com.yyw.bookExchange.dao.CommentDao;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * book services
 *
 * @author frank
 */

@RestController
public class CBook {


    private final BookDao bookDao;
    private final CommentDao commentDao;

    @Autowired
    public CBook(BookDao dao, CommentDao cdao) {
        this.bookDao = dao;
        this.commentDao = cdao;
    }

    @PostMapping("/book")
    public ReturnWrap<Void> add(@RequestBody Book b) {
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @DeleteMapping("/book/{id}")
    public ReturnWrap<Void> delete(@PathVariable Long id) {
        bookDao.deleteById(id);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/book/{id}")
    public ReturnWrap<Book> get(@PathVariable Long id) {
        return ReturnWrap.returnWithData(bookDao.getOne(id));
    }

    @PutMapping("/book")
    public ReturnWrap<Void> modify(@RequestBody Book b) {
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }


    @PutMapping("/book/{id}/pf/{value}")
    public ReturnWrap<Void> m(@PathVariable Long id, @PathVariable int value) {
        Book b = bookDao.getOne(id);
        b.setMan(b.getMan() + 1);
        b.setValue(b.getValue() + value);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/books")
    public ReturnWrap<List<Book>> get() {
        return ReturnWrap.returnWithData(bookDao.findAll());
    }

    @PutMapping("/book/{id}/loveadd")
    public ReturnWrap<Void> loveAdd(@PathVariable long id) {
        Book b = bookDao.getOne(id);
        b.setLove(b.getLove() + 1);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/book/{id}/notloveadd")
    public ReturnWrap<Void> notLoveAdd(@PathVariable long id) {
        Book b = bookDao.getOne(id);
        b.setNotLove(b.getNotLove() + 1);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }


    @PutMapping("/book/{id}/saveadd")
    public ReturnWrap<Void> saveAdd(@PathVariable long id) {
        Book b = bookDao.getOne(id);
        b.setSave(b.getSave() + 1);
        bookDao.save(b);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/book/{id}/comment")
    public ReturnWrap<List<Comment>> GetComment(@PathVariable long id) {
        List<Comment> c = commentDao.findAll();
        c = c.stream().filter(b -> b.getBook_id() == id).collect(Collectors.toList());
        return ReturnWrap.returnWithData(c);
    }

    @GetMapping("/book/search/{name}")
    public ReturnWrap<List<Book>> searchByName(@PathVariable String name) {
        List<Book> c = bookDao.findAll();
        c = c.stream().filter(b -> b.getName().contains(name) || b.getIsbn().contains(name)).collect(Collectors.toList());
        return ReturnWrap.returnWithData(c);
    }


}
