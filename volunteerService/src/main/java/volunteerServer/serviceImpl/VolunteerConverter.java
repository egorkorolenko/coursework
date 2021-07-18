package volunteerServer.serviceImpl;

import org.springframework.stereotype.Component;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Volunteer;

@Component
public class VolunteerConverter {

    public Volunteer fromVolunteerDtoToVolunteer(VolunteerDto volunteerDto) {
        Volunteer newVolunteer = new Volunteer();
        newVolunteer.setId(volunteerDto.getId());
        newVolunteer.setUsername(volunteerDto.getUsername());
        newVolunteer.setBirthdate(volunteerDto.getBirthdate());
        newVolunteer.setEmail(volunteerDto.getEmail());
        newVolunteer.setLogin(volunteerDto.getLogin());
        newVolunteer.setPassword(volunteerDto.getPassword());
        return newVolunteer;
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
