package volunteerServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import volunteerServer.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
