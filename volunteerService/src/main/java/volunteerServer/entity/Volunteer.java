package volunteerServer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "volunteer")
@Data
@NoArgsConstructor
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String birthdate;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;
}
