package volunteerServer.converters;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import volunteerServer.dto.ResponseDto;
import volunteerServer.entity.Response;
import volunteerServer.repository.RequestRepository;
import volunteerServer.repository.VolunteerRepository;

@Component
@CrossOrigin
@AllArgsConstructor
public class ResponseConverter {
    private final VolunteerRepository volunteerRepository;
    private final RequestRepository requestRepository;

    public Response fromResponseDtoToResponse(ResponseDto report) {
        Response response = new Response();
        response.setId(report.getId());
        response.setResponse(response.getResponse());
        response.setId_request(requestRepository.getById(report.getId_request()));
        response.setId_volunteer(volunteerRepository.getById(report.getId_volunteer()));
        response.setRequestIsReady(report.getRequestIsReady());
        return response;
    }

    public ResponseDto fromResponseToResponseDto(Response response) {
        return ResponseDto.builder()
                .id(response.getId())
                .response(response.getResponse())
                .id_volunteer(response.getId_volunteer().getId())
                .id_request(response.getId_request().getId())
                .requestIsReady(response.getRequestIsReady())
                .build();

    }
}
