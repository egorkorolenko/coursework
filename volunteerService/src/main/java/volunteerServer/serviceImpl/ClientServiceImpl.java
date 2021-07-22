package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volunteerServer.dto.ClientDto;
import volunteerServer.dto.RequestDto;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Client;
import volunteerServer.entity.Volunteer;
import volunteerServer.error.ServiceErrorCode;
import volunteerServer.error.ServiceException;
import volunteerServer.repository.ClientRepository;
import volunteerServer.service.ClientService;
import volunteerServer.serviceUtils.ClientUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter = new ClientConverter();
    private final ClientUtils clientUtils = new ClientUtils();

    @Override
    public ClientDto registerClient(ClientDto dto) throws ServiceException {
        clientUtils.validateDto(dto);
        Client client = clientRepository.save(clientConverter.fromClientDtoToClient(dto));
        return clientConverter.fromClientToClientDto(client);
    }

    @Override
    public ClientDto findByLogin(String login) throws ServiceException {
        if (login == null || login.equals("")) {
            throw new ServiceException(ServiceErrorCode.INVALID_LOGIN);
        }
        Client client = clientRepository.findByLogin(login);
        if (client != null) {
            return clientConverter.fromClientToClientDto(client);
        }
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }

    @Override
    public ClientDto getById(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return clientConverter.fromClientToClientDto(client.get());
        }
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }

    @Override
    public void deleteClient(Integer id) throws ServiceException {
        if (id == null) {
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientConverter::fromClientToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public RequestDto addRequest() {
        return null;
    }
}
