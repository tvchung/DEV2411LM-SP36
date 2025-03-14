package com.devmaster.lesson07.com.devmaster.lesson07.repository;

import com.devmaster.lesson07.com.devmaster.lesson07.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Kiểm tra userName trùng
    Boolean existsByUserName(String userName);
}
