package com.devmaster.lesson10_auth.service;

import com.devmaster.lesson10_auth.entity.User;
import com.devmaster.lesson10_auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
