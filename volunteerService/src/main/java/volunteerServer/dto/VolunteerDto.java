package volunteerServer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerDto {
    private Integer id;
    private String username;
    private String birthdate;
    private String email;
    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;
}
