package com.my_product.service;

import com.my_product.entity.User;
import com.my_product.entity.UserRole;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void  deleteUser(Long userId);

}
