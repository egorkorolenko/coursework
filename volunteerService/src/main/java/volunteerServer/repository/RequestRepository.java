package volunteerServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import volunteerServer.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}
