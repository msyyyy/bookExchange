package com.yyw.bookExchange.services;

import com.yyw.bookExchange.dao.BookInListDao;
import com.yyw.bookExchange.dao.BookListDao;
import com.yyw.bookExchange.data.BookInList;
import com.yyw.bookExchange.data.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookInListService {
    private BookInListDao bookInListDao;
    @Autowired
    public BookInListService(BookInListDao bookInListDao){
        this.bookInListDao = bookInListDao;
    }

    public void createBookInList(BookInList bookInList) {
        bookInListDao.save(bookInList);
    }

    public List<BookInList> getBookInList(String list_name) {
        return bookInListDao.findAll().stream().filter(bookInList -> bookInList.getList_name() .equals(list_name)).collect(Collectors.toList());
    }
}
