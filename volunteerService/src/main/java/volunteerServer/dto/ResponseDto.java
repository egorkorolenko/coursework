package volunteerServer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Integer id;
    private String response;
    private Integer idRequest;
    private Integer idVolunteer;
    private Boolean isReady = false;
}
