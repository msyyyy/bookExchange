package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.data.BookLabel;
import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.services.BookLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booklabel")
public class BookLabelController {
    @Autowired
    private BookLabelService bookLabelService;

    @PostMapping("/create")
    private ReturnWrap<Void> createLabel(@RequestBody BookLabel bookLabel) {
        bookLabelService.putBookLabel(bookLabel);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/comment/{id}")
    private ReturnWrap<Void> motifyLabelNum(@RequestBody BookLabel bookLabel,@PathVariable long id) {
        bookLabel.setId(id);
        bookLabelService.putBookLabel(bookLabel);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/getlabels/{id}")
    private List<BookLabel> getBookLabels(@PathVariable long bookId) {
        return bookLabelService.getBookLabelInfo(bookId);
    }

}
