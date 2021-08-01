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

    private int id;
    private String response;
    private Integer id_request;
    private Integer id_volunteer;
    private Boolean requestIsReady;
}
