package com.devmaster.lesson06.service;

import com.devmaster.lesson06.entity.User;
import com.devmaster.lesson06.repository.UserRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepsitory userRepsitory;

    // Lấy toàn bộ user
    public List<User> getAllUsers(){
        return userRepsitory.findAll();
    }

    // Lấy user theo id
    public User getUserById(Long id){
        return userRepsitory.findById(id).get();
    }
    // Tạo mới user
    public User addUser(User user){
        return userRepsitory.save(user);
    }

    // Cập nhật user
    public User updateUser(User user){
        return userRepsitory.save(user);
    }

    // Xóa
    public void deleteUser(Long id){
        userRepsitory.deleteById(id);
    }
}
