package volunteerServer.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "response")
@Data
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "response")
    private String response;

    @OneToOne
    @JoinColumn(name = "id_request")
    private Request id_request;

    @OneToOne
    @JoinColumn(name = "id_volunteer")
    private Volunteer id_volunteer;

    @Column(name = "requestIsReady")
    private Boolean requestIsReady;
}

