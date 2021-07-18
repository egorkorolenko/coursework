package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Volunteer;
import volunteerServer.error.ServiceError;
import volunteerServer.error.ServiceErrorCode;
import volunteerServer.repository.VolunteerRepository;
import volunteerServer.service.VolunteerService;

import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;
    private final VolunteerConverter volunteerConverter;

    @Override
    public VolunteerDto registerVolunteer(VolunteerDto dto) {
        validateVolunteerDto(dto);
        Volunteer volunteer = volunteerRepository.save(volunteerConverter.fromVolunteerDtoToVolunteer(dto));
        return volunteerConverter.fromVolunteerToVolunteerDto(volunteer);
    }

    @Override
    public VolunteerDto loginVolunteer(String login, String password) {
        return null;
    }

    @Override
    public VolunteerDto getByLogin(String login) {

        return null;
    }

    @Override
    public void logoutVolunteer(String login) {

    }

    @Override
    public void deleteVolunteer(Integer id) {

    }

    @Override
    public List<VolunteerDto> getAllVolunteer() {
        return null;
    }

    @Override
    public int getRequest() {
        return 0;
    }

    public static void validateVolunteerDto(VolunteerDto volunteerDto) {
        if (volunteerDto == null) {
            try {
                throw new ServiceError(ServiceErrorCode.OBJECT_CANNOT_BE_NULL);
            } catch (ServiceError serviceError) {
                serviceError.printStackTrace();
            }
        }
    }
}
