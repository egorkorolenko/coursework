package volunteerServer.serviceImpl;

import org.springframework.stereotype.Component;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Volunteer;

@Component
public class VolunteerConverter {

    public Volunteer fromVolunteerDtoToVolunteer(VolunteerDto volunteerDto) {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(volunteerDto.getId());
        volunteer.setUsername(volunteerDto.getUsername());
        volunteer.setBirthdate(volunteer.getBirthdate());
        volunteer.setEmail(volunteer.getEmail());
        volunteer.setLogin(volunteerDto.getLogin());
        volunteer.setPassword(volunteer.getPassword());
        return volunteer;
    }

    public VolunteerDto fromVolunteerToVolunteerDto(Volunteer volunteer) {
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
