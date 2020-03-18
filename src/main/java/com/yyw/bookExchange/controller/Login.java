package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.data.ReturnWrap;
import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Result;
import com.yyw.bookExchange.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yyw
 */
@RestController
public class Login {

    final UserDao dao;

    public static String newToken(){
        return "003768-a334bc-221fa";
    }

    @Autowired
    public Login(UserDao dao) {
        this.dao = dao;
    }

    @PostMapping("/login")
    public ReturnWrap login(@RequestBody User u){
        List<User> u1 = dao.findAll();
        for (User user : u1) {
            if (u.getPassword().equals(user.getPassword())&&u.getName().equals(user.getName())){
                return ReturnWrap.returnWithData(new Result(0,newToken()));
            }
        }
        return ReturnWrap.errorWithData("login failed!");
    }

    @PostMapping("/user")
    public ReturnWrap register(@RequestBody User u){
        dao.save(u);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/user/{id}")
    public ReturnWrap<User> get(@PathVariable Long id){
       return ReturnWrap.returnWithData(dao.getOne(id));
    }

    @GetMapping("/users")
    public ReturnWrap<List<User>> get(){
        return ReturnWrap.returnWithData(dao.findAll());
    }

    @DeleteMapping("/user/{id}")
    public ReturnWrap<Void> delete(@PathVariable Long id){
        dao.deleteById(id);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/user/{id}")
    public ReturnWrap<Void> modify(@PathVariable Long id, @RequestBody User u){
        dao.save(u);
        return ReturnWrap.SUCCEED;
    }

}
