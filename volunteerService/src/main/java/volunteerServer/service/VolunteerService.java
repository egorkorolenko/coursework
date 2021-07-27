package volunteerServer.service;

import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Request;
import volunteerServer.error.ServiceException;

import java.util.List;

public interface VolunteerService {

    VolunteerDto registerVolunteer(VolunteerDto dto) throws ServiceException;

    VolunteerDto loginVolunteer(String login, String password);

    VolunteerDto findByLogin(String login) throws ServiceException;

    void logoutVolunteer(String login);

    void deleteVolunteer(Integer id) throws ServiceException;

    List<VolunteerDto> getAllVolunteer();

    VolunteerDto getById(Integer id) throws ServiceException;

    List<Request> getClientRequest();
}
