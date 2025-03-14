package com.devmaster.lesson06.controller;

import com.devmaster.lesson06.entity.User;
import com.devmaster.lesson06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // GetAll
    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    // tạo user
    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userService.addUser(user);
    }
}
