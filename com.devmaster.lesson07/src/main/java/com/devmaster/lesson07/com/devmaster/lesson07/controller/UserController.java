package com.devmaster.lesson07.com.devmaster.lesson07.controller;

import com.devmaster.lesson07.com.devmaster.lesson07.entity.User;
import com.devmaster.lesson07.com.devmaster.lesson07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return  "user/list";
    }

    @PostMapping("/sava")
    public String saveUser (@Validated  @ModelAttribute("User") User user, BindingResult result, Model model){
        if(userService.existByUserName(user.getUserName()) && user.getId()==null){
            result.rejectValue("userName","error.user","Tài khoản đã tồn tại");
            return "user/form";
        }
        if(result.hasErrors()){
            return "user/form";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

}
