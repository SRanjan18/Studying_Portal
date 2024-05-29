package studyingPortalUserManagement.studyingPortal.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponse {
    String message;
    Boolean status;

}