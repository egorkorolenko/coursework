package serviceImpl;

import controller.VolunteerController;
import dto.VolunteerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.VolunteerRepository;
import service.VolunteerService;

import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;
    private final VolunteerController volunteerController;

    @Override
    public VolunteerDto registerVolunteer(VolunteerDto dto) {
        return null;

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
