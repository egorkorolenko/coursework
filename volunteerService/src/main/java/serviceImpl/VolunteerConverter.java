package serviceImpl;

import dto.VolunteerDto;
import entity.Volunteer;
import org.springframework.stereotype.Component;

@Component
public class VolunteerConverter {

    public Volunteer fromUserDtoToUser(VolunteerDto volunteerDto) {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(volunteerDto.getId());
        volunteer.setUsername(volunteerDto.getUsername());
        volunteer.setBirthdate(volunteer.getBirthdate());
        volunteer.setEmail(volunteer.getEmail());
        volunteer.setLogin(volunteerDto.getLogin());
        volunteer.setPassword(volunteer.getPassword());
        return volunteer;
    }

    public VolunteerDto fromUserToUserDto(Volunteer volunteer) {
        return VolunteerDto.builder()
                .id(volunteer.getId())
                .username(volunteer.getUsername())
                .birthdate(volunteer.getBirthdate())
                .email(volunteer.getEmail())
                .login(volunteer.getLogin())
                .password(volunteer.getPassword())
                .build();
    }
}
