package volunteerServer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private Integer id;
    private String request_text;
    private String address;
    private Boolean request_is_ready = false;
    private Integer id_client;
    private Integer id_volunteer;
}
