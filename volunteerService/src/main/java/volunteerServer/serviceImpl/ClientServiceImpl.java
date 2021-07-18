package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volunteerServer.dto.ClientDto;
import volunteerServer.entity.Client;
import volunteerServer.repository.ClientRepository;
import volunteerServer.service.ClientService;
import volunteerServer.serviceUtils.ClientUtils;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter = new ClientConverter();
    private final ClientUtils clientUtils = new ClientUtils();

    @Override
    public ClientDto registerClient(ClientDto dto) {
        clientUtils.validateDto(dto);
        Client client = clientRepository.save(clientConverter.fromClientDtoToClient(dto));
        return clientConverter.fromClientToClientDto(client);
    }
}
