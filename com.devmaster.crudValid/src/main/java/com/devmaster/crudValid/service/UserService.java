package com.devmaster.crudValid.service;

import com.devmaster.crudValid.entity.User;
import com.devmaster.crudValid.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User saveUser(User user) {
        if(user.getId() == null) {
            return userRepository.save(user);
        }
        User user1 = userRepository.findById(user.getId()).get();
        user1.setId(user1.getId());
        user1.setFullName(user.getFullName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        user1.setPhone(user.getPhone());
        user1.setIsActive(user.getIsActive());
        return userRepository.save(user1);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public  boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }
}
