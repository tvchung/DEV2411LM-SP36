package com.devmaster.lesson07.com.devmaster.lesson07.service;

import com.devmaster.lesson07.com.devmaster.lesson07.entity.User;
import com.devmaster.lesson07.com.devmaster.lesson07.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // List user
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    // get user by id
    @Transactional
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    // saveuser
    @Transactional
    public User saveUser(User user){
        // Nếu là thêm mới
        if(user.getId() == null){
            return userRepository.save(user);
        }
        // Sửa => cập nhật
        User user1 = userRepository.findById(user.getId()).get();
        user1.setId(user1.getId());
        user1.setFullName(user.getFullName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setIsActive(user.getIsActive());

        return userRepository.save(user1);
    }
    // delete user
    @Transactional
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    // exist username
    public Boolean existByUserName(String userName){
        return  userRepository.existsByUserName(userName);
    }
}
