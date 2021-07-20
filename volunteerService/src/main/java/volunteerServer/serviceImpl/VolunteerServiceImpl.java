package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Volunteer;
import volunteerServer.error.ServiceErrorCode;
import volunteerServer.error.ServiceException;
import volunteerServer.repository.VolunteerRepository;
import volunteerServer.service.VolunteerService;
import volunteerServer.serviceUtils.VolunteerUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {

    private final VolunteerRepository volunteerRepository;
    private final VolunteerConverter volunteerConverter;
    private final VolunteerUtils volunteerUtils = new VolunteerUtils();

    @Override
    public VolunteerDto registerVolunteer(VolunteerDto dto) throws ServiceException {
        volunteerUtils.validateDto(dto);
        Volunteer volunteer = volunteerRepository.save(volunteerConverter.fromVolunteerDtoToVolunteer(dto));
        return volunteerConverter.fromVolunteerToVolunteerDto(volunteer);
    }

    @Override
    public VolunteerDto loginVolunteer(String login, String password) {
        return null;
    }

    @Override
    public VolunteerDto findByLogin(String login) throws ServiceException {
        if (login == null || login.equals("")) {
            throw new ServiceException(ServiceErrorCode.INVALID_LOGIN);
        }
        Volunteer volunteer = volunteerRepository.findByLogin(login);
        if (volunteer != null) {
            return volunteerConverter.fromVolunteerToVolunteerDto(volunteer);
        }
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }

    @Override
    public void logoutVolunteer(String login) {

    }

    @Override
    public void deleteVolunteer(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        volunteerRepository.deleteById(id);
    }

    @Override
    public List<VolunteerDto> getAllVolunteer() {
        return volunteerRepository.findAll()
                .stream()
                .map(volunteerConverter::fromVolunteerToVolunteerDto)
                .collect(Collectors.toList());
    }

    @Override
    public int getRequest() {
        return 0;
    }

    @Override
    public VolunteerDto getById(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        Optional<Volunteer> volunteer = volunteerRepository.findById(id);
        if (volunteer.isPresent()) {
            return volunteerConverter.fromVolunteerToVolunteerDto(volunteer.get());
        }
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }
}
