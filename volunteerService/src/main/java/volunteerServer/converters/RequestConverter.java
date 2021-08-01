package volunteerServer.converters;

import org.springframework.stereotype.Component;
import volunteerServer.dto.RequestDto;
import volunteerServer.entity.Request;

@Component
public class RequestConverter {
    public Request fromRequestDtoToRequest(RequestDto requestDto) {
        Request request = new Request();
        request.setId(request.getId());
        request.setRequest_text(requestDto.getRequest_text());
        request.setAddress(requestDto.getAddress());
        request.setRequest_is_ready(requestDto.getRequest_is_ready());
        request.setId_client(request.getId_client());
        request.setId_volunteer(request.getId_volunteer());
        return request;
    }

    public RequestDto fromRequestToRequestDto(Request request) {
        return RequestDto.builder()
                .id(request.getId())
                .request_text(request.getRequest_text())
                .address(request.getAddress())
                .request_is_ready(request.getRequest_is_ready())
                .id_client(request.getId_client().getId())
                .id_volunteer(null)
                .build();
    }
}
