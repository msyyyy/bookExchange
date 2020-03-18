package com.yyw.bookExchange.controller;

import com.yyw.bookExchange.dao.UserDao;
import com.yyw.bookExchange.data.Result;
import com.yyw.bookExchange.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result Login(@RequestBody User u){
        List<User> u1 = dao.findAll();
        for (User user : u1) {
            if (u.getPassword().equals(user.getPassword())&&u.getName().equals(user.getName())){
                return new Result(0,newToken());
            }
        }
        return new Result(-1,"error");
    }

    @PostMapping("/login")
    public Result Register(@RequestBody User u){
        dao.save(u);
        return new Result(0,"succeed");
    }

    @GetMapping("/login/{id}")
    public User Get(@PathVariable Long id){
       return dao.findById(id).get();
    }

    @DeleteMapping("/login/{id}")
    public Result delete(@PathVariable Long id){
        dao.deleteById(id);
        return new Result(0,"succeed");
    }

    @PutMapping("/login/{id}")
    public Result Delete(@PathVariable Long id,@RequestBody User u){
        dao.deleteById(id);
        dao.save(u);
        return new Result(0,"succeed");
    }

}
