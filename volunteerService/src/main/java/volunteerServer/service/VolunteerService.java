package volunteerServer.service;

import volunteerServer.dto.VolunteerDto;
import volunteerServer.error.ServiceException;

import java.util.List;

public interface VolunteerService {

    VolunteerDto registerVolunteer(VolunteerDto dto);

    VolunteerDto loginVolunteer(String login, String password);

    VolunteerDto findByLogin(String login) throws ServiceException;

    void logoutVolunteer(String login);

    void deleteVolunteer(Integer id) throws ServiceException;

    List<VolunteerDto> getAllVolunteer();

    //todo написать что-то во входных параметрах
    int getRequest();

    VolunteerDto getById(Integer id) throws ServiceException;

}
