package com.my_product;

import com.my_product.entity.Role;
import com.my_product.entity.User;
import com.my_product.entity.UserRole;
import com.my_product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MyProductApplication implements CommandLineRunner {
@Autowired
	private UserService userService;
	public static void main(String[] args) {

		SpringApplication.run(MyProductApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
   		System.out.println("start");

//		User user=new User();
//
//		user.setFirstname("Soumya");
//		user.setLastname("Ranjan");
//		user.setUsername("SR");
//		user.setPassword("abc");
//		user.setEmail("abc@gmail.com");
//		user.setProfile("default.png");
//
//
//		Role role1=new Role();
//      role1.setRoleId(44l);
//		role1.setRoleName("ADMIN");

//      setting userroles
//		Set<UserRole>userRoleSet=new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());

	}
}



//Step 1- created User(30)
//        gave user info 32-37
//        created role 40
//        and userrole set 45
// then set the userroles inside userRoleset 45
//then set user in userole
//then set role in userrole
//thn add userroleset to userrole 50
//simply pass userroleset to createuser 52 which returns user1
//print username of user1 53
