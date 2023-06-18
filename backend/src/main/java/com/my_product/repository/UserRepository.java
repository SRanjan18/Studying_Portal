package com.my_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.my_product.entity.User;
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

}
