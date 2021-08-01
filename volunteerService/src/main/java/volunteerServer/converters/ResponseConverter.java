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
        response.setResponse(report.getResponse());
        response.setIdRequest(requestRepository.getById(report.getIdRequest()));
        response.setIdVolunteer(volunteerRepository.getById(report.getIdVolunteer()));
        response.setIsReady(report.getIsReady());
        return response;
    }

    public ResponseDto fromResponseToResponseDto(Response response) {
        return ResponseDto.builder()
                .id(response.getId())
                .response(response.getResponse())
                .idVolunteer(response.getIdVolunteer().getId())
                .idRequest(response.getIdRequest().getId())
                .isReady(response.getIsReady())
                .build();

    }
}
