package volunteerServer.service;

import volunteerServer.dto.ClientDto;
import volunteerServer.dto.VolunteerDto;

public interface ClientService {

    ClientDto registerClient(ClientDto dto);
}
