package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Volunteer;
import volunteerServer.repository.VolunteerRepository;
import volunteerServer.service.VolunteerService;
import volunteerServer.serviceUtils.VolunteerUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;
    private final VolunteerConverter volunteerConverter;
    private final VolunteerUtils volunteerUtils = new VolunteerUtils();

    @Override
    public VolunteerDto registerVolunteer(VolunteerDto dto) {
        volunteerUtils.validateVolunteerDto(dto);
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
}
