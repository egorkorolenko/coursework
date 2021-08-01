package volunteerServer.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import volunteerServer.converters.ClientConverter;
import volunteerServer.converters.RequestConverter;
import volunteerServer.dto.ClientDto;
import volunteerServer.dto.RequestDto;
import volunteerServer.entity.Client;
import volunteerServer.entity.Request;
import volunteerServer.error.ServiceErrorCode;
import volunteerServer.error.ServiceException;
import volunteerServer.repository.ClientRepository;
import volunteerServer.repository.RequestRepository;
import volunteerServer.service.ClientService;
import volunteerServer.serviceUtils.ClientUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Log
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final RequestRepository requestRepository;
    private final ClientConverter clientConverter = new ClientConverter();
    private final RequestConverter requestConverter = new RequestConverter();
    private final ClientUtils clientUtils = new ClientUtils();

    @Override
    public ClientDto registerClient(ClientDto dto) throws ServiceException {
        clientUtils.validateDto(dto);
        Client client = clientRepository.save(clientConverter.fromClientDtoToClient(dto));
        return clientConverter.fromClientToClientDto(client);
    }

    @Override
    public RequestDto addRequest(Integer id, RequestDto requestDto) throws ServiceException {
        if (id == null) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_ID));
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        ClientDto clientDto = getById(id);
        Client client;
        if (clientDto == null) {
            log.info(String.valueOf(ServiceErrorCode.CLIENT_NOT_FOUND));
            throw new ServiceException(ServiceErrorCode.CLIENT_NOT_FOUND);
        } else {
            client = clientConverter.fromClientDtoToClient(clientDto);
        }
        if (requestDto.getRequest_text() == null || requestDto.getRequest_text().equals("")) {
            log.info(String.valueOf(ServiceErrorCode.REQUEST_TEXT_INCORRECT));
            throw new ServiceException(ServiceErrorCode.REQUEST_TEXT_INCORRECT);
        }
        if (requestDto.getAddress() == null || requestDto.getAddress().equals("")) {
            log.info(String.valueOf(ServiceErrorCode.ADDRESS_INCORRECT));
            throw new ServiceException(ServiceErrorCode.ADDRESS_INCORRECT);
        }
        Request request = requestConverter.fromRequestDtoToRequest(requestDto);
        request.setId_client(client);
        Request newRequest =
                requestRepository.save(request);
        return requestConverter.fromRequestToRequestDto(newRequest);
    }

    @Override
    public void removeRequest(Integer id, RequestDto requestDto) throws ServiceException {
        log.info("Id request" + requestDto.getId_client());
        if (requestDto.getId_client() == null) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_ID));
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
//        List<Request> requests = getRequestByIdClient(id);
        requestRepository.deleteById(requestDto.getId());
    }

    @Override
    public List<Request> getMyRequests(Integer id) throws ServiceException {
        Client client = clientConverter.fromClientDtoToClient(getById(id));
        return requestRepository.findAll()
                .stream()
                .filter(request -> request.getId_client().equals(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findByLogin(String login) throws ServiceException {
        if (login == null || login.equals("")) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_LOGIN));
            throw new ServiceException(ServiceErrorCode.INVALID_LOGIN);
        }
        Client client = clientRepository.findByLogin(login);
        if (client != null) {
            return clientConverter.fromClientToClientDto(client);
        }
        log.info(String.valueOf(ServiceErrorCode.LOGIN_NOT_FOUND));
        throw new ServiceException(ServiceErrorCode.LOGIN_NOT_FOUND);
    }

    @Override
    public ClientDto getById(Integer id) throws ServiceException {
        if (id == null) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_ID));
            throw new ServiceException(ServiceErrorCode.INVALID_ID);
        }
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return clientConverter.fromClientToClientDto(client.get());
        }
        log.info(String.valueOf(ServiceErrorCode.CLIENT_NOT_FOUND));
        throw new ServiceException(ServiceErrorCode.CLIENT_NOT_FOUND);
    }

    @Override
    public void deleteClient(Integer id) throws ServiceException {
        if (id == null) {
            log.info(String.valueOf(ServiceErrorCode.INVALID_ID));
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

}
