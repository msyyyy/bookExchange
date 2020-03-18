package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.dao.ReturnWrap;
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

    @GetMapping("/login")
    public ReturnWrap login(@RequestBody User u){
        List<User> u1 = dao.findAll();
        for (User user : u1) {
            if (u.getPassword().equals(user.getPassword())&&u.getName().equals(user.getName())){
                return ReturnWrap.returnWithData(new Result(0,newToken()));
            }
        }
        return ReturnWrap.errorWithData("login failed!");
    }

    @PostMapping("/login")
    public ReturnWrap register(@RequestBody User u){
        dao.save(u);
        return ReturnWrap.SUCCEED;
    }

    @GetMapping("/login/{id}")
    public User Get(@PathVariable Long id){
       return dao.getOne(id);
    }

    @DeleteMapping("/login/{id}")
    public ReturnWrap delete(@PathVariable Long id){
        dao.deleteById(id);
        return ReturnWrap.SUCCEED;
    }

    @PutMapping("/login/{id}")
    public ReturnWrap Delete(@PathVariable Long id, @RequestBody User u){
        dao.deleteById(id);
        dao.save(u);
        return ReturnWrap.SUCCEED;
    }

}
