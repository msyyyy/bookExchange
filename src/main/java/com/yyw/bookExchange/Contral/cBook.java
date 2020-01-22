package com.yyw.bookExchange.Contral;

import com.yyw.bookExchange.Dao.BookDao;
import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class cBook {
    @Autowired
    BookDao dao;

    @PostMapping("/book")
    public Result Add(@RequestBody Book b){
        dao.save(b);
        return new Result(0,"success");
    }

    @DeleteMapping("/book/{id}")
    public Result Add(@PathVariable Long id){
        dao.deleteById(id);
        return new Result(0,"success");
    }

    @GetMapping("/book/{id}")
    public Book Get(  @PathVariable Long id){
        return dao.findById(id).get();
    }

    @PutMapping("/book")
    public Result Modify(@RequestBody Book b){
     //   dao.
        return new Result(0,"success");
    }

}
