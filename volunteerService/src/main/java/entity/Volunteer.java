package entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "volunteer")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Volunteer volunteer = (Volunteer) o;

        return Objects.equals(id, volunteer.id);
    }

    @Override
    public int hashCode() {
        return 1280901492;
    }
}
