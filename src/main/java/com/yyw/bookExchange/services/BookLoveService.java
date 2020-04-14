package com.yyw.bookExchange.services;

import com.yyw.bookExchange.dao.BookLoveDao;
import com.yyw.bookExchange.data.BookLove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookLoveService {

    private BookLoveDao bookLoveDao;
    @Autowired
    public BookLoveService(BookLoveDao bookLoveDao) {
        this.bookLoveDao = bookLoveDao;
    }

    public List<BookLove> getBookLoveByUserId(long user_id) {
        return bookLoveDao.findAll().stream().filter(b -> b.getUser_id() == user_id).collect(Collectors.toList());
    }

    public void saveBookLove(BookLove bookLove) {
        bookLoveDao.save(bookLove);
    }

}
