package com.my_product.controller;

import com.my_product.entity.Role;
import com.my_product.entity.User;
import com.my_product.entity.UserRole;
import com.my_product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        return "Backend API successfull";
    }
    //create user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        Set<UserRole> roles=new HashSet<>();

        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("Guest");


        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);


        roles.add(userRole);
    return this.userService.createUser(user,roles);
    }
@GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
}

//delete user by id
    @DeleteMapping("/{userId}")
    public  void deleteUser(@PathVariable("userId")Long userId){
        this.userService.deleteUser(userId);

    }


}
