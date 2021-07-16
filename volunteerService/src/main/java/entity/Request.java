package entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String requestText;

    @Column
    private String address;

    @Column
    private String isReady;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Request request = (Request) o;

        return Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return 643690654;
    }
}
