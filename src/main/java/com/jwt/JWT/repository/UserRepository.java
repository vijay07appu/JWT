package com.jwt.JWT.repository;

import com.jwt.JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByUserName(String userName);
}
