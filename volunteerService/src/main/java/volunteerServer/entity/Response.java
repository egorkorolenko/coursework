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
    private Integer id;

    @Column(name = "response")
    private String response;

    @OneToOne
    @JoinColumn(name = "id_request")
    private Request idRequest;

    @OneToOne
    @JoinColumn(name = "id_volunteer")
    private Volunteer idVolunteer;

    @Column(name = "isready")
    private Boolean isReady = false;
}

