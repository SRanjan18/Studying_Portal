package studyingPortalUserManagement.studyingPortal.Service;

import org.springframework.stereotype.Service;
import studyingPortalUserManagement.studyingPortal.Dto.LoginDto;
import studyingPortalUserManagement.studyingPortal.Dto.UserDto;
import studyingPortalUserManagement.studyingPortal.Response.LoginResponse;


public interface UserService  {
    String addEmployee(UserDto userDto);
    LoginResponse loginEmployee(LoginDto loginDTO);
}
