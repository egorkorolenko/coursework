package volunteerServer.serviceImpl;

import volunteerServer.dto.RequestDto;
import volunteerServer.entity.Client;
import volunteerServer.entity.Request;

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

    public RequestDto fromRequestToRequestDto(Request request, Client client) {
        return RequestDto.builder()
                .id(request.getId())
                .request_text(request.getRequest_text())
                .address(request.getAddress())
                .request_is_ready(request.getRequest_is_ready())
                .id_client(client.getId())
                .id_volunteer(null)
                .build();
    }
}
