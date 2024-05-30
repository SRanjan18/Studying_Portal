package studyingPortalUserManagement.studyingPortal.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studyingPortalUserManagement.studyingPortal.Dto.LoginDto;
import studyingPortalUserManagement.studyingPortal.Dto.UserDto;
import studyingPortalUserManagement.studyingPortal.Response.LoginResponse;
import studyingPortalUserManagement.studyingPortal.Service.UserService;
import studyingPortalUserManagement.studyingPortal.exceptions.UserAlreadyExistsException;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path = "/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        try {
            String id = userService.addEmployee(userDto);
            return ResponseEntity.ok(id);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = userService.loginEmployee(loginDto);
        if (loginResponse.getStatus()) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(loginResponse);
        }
    }

}
