package volunteerServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import volunteerServer.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {

    Volunteer getByLogin(String login);
}
