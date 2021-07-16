package service;

import dto.ClientDto;
import dto.VolunteerDto;

import java.util.List;

public interface VolunteerService {

    VolunteerDto registerVolunteer(VolunteerDto dto);

    VolunteerDto loginVolunteer(String login, String password);

    VolunteerDto getByLogin(String login);

    void logoutVolunteer(String login);

    void deleteVolunteer(Integer id);

    List<VolunteerDto> getAllVolunteer();

    //todo написать что-то во входных параметрах
    int getRequest();

}
