package com.yyw.bookExchange.controller;


import com.yyw.bookExchange.dao.BookLoveDao;
import com.yyw.bookExchange.data.BookLove;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.services.BookLoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booklove")
public class BookLoveController {
    @Autowired
    private BookLoveService bookLoveService;

    @GetMapping("/{id}")
    public List<BookLove> getOneBookLove(@PathVariable long id) {
        return bookLoveService.getBookLoveByUserId(id);
    }
    @PostMapping("/save")
    public ReturnWrap<Void> putOneBookLove(@RequestBody BookLove bookLove) {
        bookLove.setCreate_time(System.currentTimeMillis());
        bookLoveService.saveBookLove(bookLove);
        return ReturnWrap.SUCCEED;
    }



}
