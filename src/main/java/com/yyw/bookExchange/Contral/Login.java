package com.yyw.bookExchange.Contral;

import com.yyw.bookExchange.Dao.UserDao;
import com.yyw.bookExchange.data.Result;
import com.yyw.bookExchange.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Login {

    @Autowired
    UserDao dao;
    @PutMapping("/login")
    public Result Login(User u){
        List<User> u1 = dao.findAll();
        for (User user : u1) {
            if (u.getPassword().equals(user.getPassword())&&u.getName().equals(user.getName())){
                return new Result(0,"123");
            }
        }
        return new Result(-1,"error");
    }

    @PostMapping("/login")
    public Result Register(@RequestBody User u){
        dao.save(u);
        return new Result(0,"succeed");
    }

    @GetMapping("/login")
    public List<User> Get(){
       return dao.findAll();
    }

    @DeleteMapping("/login/{id}")
    public Result Delete(@PathVariable Long id){
        dao.deleteById(id);
        return new Result(0,"succeed");
    }

}
