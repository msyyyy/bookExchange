package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.data.BookList;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.services.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booklist")
public class BookListController {
    @Autowired
    private BookListService bookListService;

    @GetMapping("get/{user_id}")
    public List<BookList> getBookList(@PathVariable long user_id) {
        return bookListService.getBookList(user_id);
    }

    @PostMapping("/save")
    public ReturnWrap<Void> putBookList(@RequestBody BookList bookList) {
        bookListService.createBookList(bookList);
        return ReturnWrap.SUCCEED;
    }
}
