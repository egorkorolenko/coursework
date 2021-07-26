package volunteerServer.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "request")
@Data
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "request_text")
    private String request_text;

    @Column
    private String address;

    @Column(name = "request_is_ready")
    private Boolean request_is_ready;

//    @Column
//    private Integer id_client;
//
//    @Column
//    private Integer id_volunteer;
//
    @OneToOne
    @JoinColumn(name = "id_client")
    private Client id_client;
//
    @OneToOne
    @JoinColumn(name = "id_volunteer")
    private Volunteer id_volunteer;
}
