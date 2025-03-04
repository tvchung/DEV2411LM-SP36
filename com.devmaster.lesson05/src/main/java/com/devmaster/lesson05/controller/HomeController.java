package com.devmaster.lesson05.controller;

import com.devmaster.lesson05.entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // Đưa dữ liệu từ controller lên view (thymeleaf)
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("Devmaster Academy",
                    "DEV",
                    "chungtrinhj@gmail.com",
                    "https://devmaster.edu.vn"));
        // Đưa dữ liệu vào model
        model.addAttribute("devmasterProfile", profile);
        return "profile";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Devmaster::Home");
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Devmaster::About");
        return "about";
    }
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Devmaster::Hãy liên hệ với chúng tôi");
        return "contact";
    }
}
