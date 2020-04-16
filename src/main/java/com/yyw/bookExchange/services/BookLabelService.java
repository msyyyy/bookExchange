package com.yyw.bookExchange.services;

import com.yyw.bookExchange.dao.BookLabelDao;
import com.yyw.bookExchange.data.BookLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookLabelService {

    private BookLabelDao bookLabelDao;
    @Autowired
    public BookLabelService(BookLabelDao bookLabelDao) {
        this.bookLabelDao = bookLabelDao;
    }

    public void putBookLabel(BookLabel bookLabel){
        bookLabelDao.save(bookLabel);
    }

    public List<BookLabel> getBookLabelInfo(long book_id){
        return bookLabelDao.findAll().stream().filter(bookLabel -> bookLabel.getBook_id() == book_id).collect(Collectors.toList());
    }

    public void motifyBookLabelNum(BookLabel bookLabel) {
        bookLabelDao.save(bookLabel);
    }
}
