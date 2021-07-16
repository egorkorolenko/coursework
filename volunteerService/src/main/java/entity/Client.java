package entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Client {
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
        Client client = (Client) o;

        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return 1756406093;
    }
}
