package studyingPortalUserManagement.studyingPortal.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
    @Column(name="user_name", length = 255)
    private String username;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;
}
