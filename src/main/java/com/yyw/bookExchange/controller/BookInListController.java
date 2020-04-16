package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.data.BookInList;
import com.yyw.bookExchange.data.BookList;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.services.BookInListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookinlist")
public class BookInListController {
    @Autowired
    private BookInListService bookInListService;

    @GetMapping("/get/{list_name}")
    public List<BookInList> getBookInList(@PathVariable String list_name) {
        System.out.println("=========" + list_name);
        return bookInListService.getBookInList(list_name);
    }

    @PostMapping("/save")
    public ReturnWrap<Void> putBookInList(@RequestBody BookInList bookInList) {
        bookInListService.createBookInList(bookInList);
        return ReturnWrap.SUCCEED;
    }
}
