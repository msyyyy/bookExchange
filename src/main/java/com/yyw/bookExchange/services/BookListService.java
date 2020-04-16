package com.yyw.bookExchange.services;

import com.yyw.bookExchange.dao.BookListDao;
import com.yyw.bookExchange.data.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookListService {
    private BookListDao bookListDao;
    @Autowired
    public BookListService(BookListDao bookListDao){
        this.bookListDao = bookListDao;
    }

    public void createBookList(BookList bookList) {
        bookListDao.save(bookList);
    }

    public List<BookList> getBookList(long user_id) {
        return bookListDao.findAll().stream().filter(bookList -> bookList.getUser_id() == user_id).collect(Collectors.toList());
    }

}
