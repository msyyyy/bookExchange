package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.data.BookCollect;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.services.BookCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookcollect")
public class BookCollectController {
    @Autowired
    private BookCollectService bookCollectService;

    @GetMapping("/{id}")
    public List<BookCollect> getOneBookCollect(@PathVariable long id) {
        return bookCollectService.getOneBookCollect(id);
    }

    @PostMapping("/save")
    public ReturnWrap<Void> getOneBookCollect(@RequestBody BookCollect bookCollect) {
        bookCollect.setCreate_time(System.currentTimeMillis());
        bookCollectService.saveBookCollect(bookCollect);
        return ReturnWrap.SUCCEED;
    }
}
