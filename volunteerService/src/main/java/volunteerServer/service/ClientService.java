package volunteerServer.service;

import volunteerServer.dto.ClientDto;
import volunteerServer.dto.RequestDto;
import volunteerServer.entity.Request;
import volunteerServer.error.ServiceException;

import java.util.List;

public interface ClientService {

    ClientDto registerClient(ClientDto dto) throws ServiceException;

    ClientDto findByLogin(String login) throws ServiceException;

    ClientDto getById(Integer id) throws ServiceException;

    void deleteClient(Integer id) throws ServiceException;

    List<ClientDto> getAllClients();

    RequestDto addRequest(Integer id, RequestDto requestDto) throws ServiceException;

    void removeRequest(Integer id, RequestDto requestDto) throws ServiceException;

    List<Request> getMyRequests(Integer id) throws ServiceException;
}
