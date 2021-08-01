package volunteerServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import volunteerServer.entity.Response;

public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
