package com.devmaster.crudValid.repository;

import com.devmaster.crudValid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
    // Dùng để kiểm tra userName trùng
    boolean existsByUserName(String userName);
}
