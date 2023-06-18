package com.my_product.service.implementation;

import com.my_product.entity.User;
import com.my_product.entity.UserRole;
import com.my_product.repository.RoleRepository;
import com.my_product.repository.UserRepository;
import com.my_product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws  Exception {
       User local= this.userRepository.findByUsername(user.getUsername());
       if(local!=null){
           System.out.println("User Exists already");
           throw new Exception("User Exists !!");
       }else{
           //user create
           for(UserRole ur:userRoles){
               roleRepository.save(ur.getRole());
           }

           user.getUserRoles().addAll(userRoles);
           local=this.userRepository.save(user);

       }
        return local;
    }
//getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
         this.userRepository.deleteById(userId);
    }
}
