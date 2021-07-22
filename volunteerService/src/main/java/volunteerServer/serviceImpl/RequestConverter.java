package volunteerServer.serviceImpl;

import volunteerServer.dto.RequestDto;
import volunteerServer.entity.Request;

public class RequestConverter {
    public Request fromRequestDtoToRequest(RequestDto requestDto) {
        Request request = new Request();
        request.setId(request.getId());
        request.setRequestText(requestDto.getRequestText());
        request.setAddress(requestDto.getAddress());
        request.setIsReady(requestDto.isReady());
        request.setId_client(request.getId_client());
        request.setId_volunteer(request.getId_volunteer());
        return request;
    }

    public RequestDto fromRequestToRequestDto(Request request) {
        return RequestDto.builder()
                .id(request.getId())
                .requestText(request.getRequestText())
                .address(request.getAddress())
                .isReady(request.getIsReady())
                .id_client(request.getId_client())
                .id_volunteer(request.getId_volunteer())
                .build();
    }
}
