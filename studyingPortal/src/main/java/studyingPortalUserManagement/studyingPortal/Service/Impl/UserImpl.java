package studyingPortalUserManagement.studyingPortal.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import studyingPortalUserManagement.studyingPortal.Dto.LoginDto;
import studyingPortalUserManagement.studyingPortal.Dto.UserDto;
import studyingPortalUserManagement.studyingPortal.Entity.User;
import studyingPortalUserManagement.studyingPortal.Repo.UserRepo;
import studyingPortalUserManagement.studyingPortal.Response.LoginResponse;
import studyingPortalUserManagement.studyingPortal.Service.UserService;
import studyingPortalUserManagement.studyingPortal.exceptions.UserAlreadyExistsException;

import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(UserDto userDto) {
        if (userRepo.findByEmail(userDto.getEmail()) != null) {
            throw new UserAlreadyExistsException("User with email " + userDto.getEmail() + " already exists");
        }

        User user = new User(
                userDto.getUserid(),
                userDto.getUsername(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword())
        );
userRepo.save(user);


        return user.getUsername();
    }
    @Override
    public LoginResponse loginEmployee(LoginDto loginDTO) {
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            if (passwordEncoder.matches(password, encodedPassword)) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Incorrect password", false);
            }
        } else {
            return new LoginResponse("Email does not exist", false);
        }
    }



}
