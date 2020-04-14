package com.yyw.bookExchange.services;

import com.yyw.bookExchange.dao.BookCollectDao;
import com.yyw.bookExchange.data.BookCollect;
import com.yyw.bookExchange.data.BookLove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCollectService {
    @Autowired
    private BookCollectDao bookCollectDao;
    public BookCollectService(BookCollectDao bookCollectDao) {
        this.bookCollectDao = bookCollectDao;
    }

    public void saveBookCollect(BookCollect bookCollect) {
        bookCollectDao.save(bookCollect);
    }

    public List<BookCollect> getOneBookCollect(long user_id){
        return bookCollectDao.findAll().stream().filter(bookCollect -> bookCollect.getUser_id() == user_id).collect(Collectors.toList());
    }
}
