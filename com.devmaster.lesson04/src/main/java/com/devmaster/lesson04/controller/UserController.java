package com.devmaster.lesson04.controller;

import com.devmaster.lesson04.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/users")
public class UserController {

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO user) {
        // Xử lý code login ở đây (khi thông qua valid)

        return ResponseEntity.ok("User created successfully");
    }

}
