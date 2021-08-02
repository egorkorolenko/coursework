package volunteerServer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volunteerServer.dto.ClientDto;
import volunteerServer.dto.RequestDto;
import volunteerServer.entity.Request;
import volunteerServer.error.ServiceException;
import volunteerServer.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Log
@CrossOrigin
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/register")
    public ClientDto registerClient(@RequestBody ClientDto clientDto) throws ServiceException {
        log.info("Volunteer register: " + clientDto);
        return clientService.registerClient(clientDto);
    }

    @PostMapping("/{id}/addRequest")
    public RequestDto addRequest(@PathVariable Integer id, @RequestBody RequestDto requestDto) throws ServiceException {
        log.info("A request was added: " + requestDto.getRequest_text());
        return clientService.addRequest(id, requestDto);
    }

    @GetMapping("/findByLogin/{login}")
    public ClientDto findByLogin(@PathVariable String login) throws ServiceException {
        log.info("Handling find by login request: " + login);
        return clientService.findByLogin(login);
    }

    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable Integer id) throws ServiceException {
        log.info("Handling find by login request: " + id);
        return clientService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Integer id) throws ServiceException {
        ClientDto clientDto = findById(id);
        log.info("Client : " + clientDto.getUsername() + " was deleted");
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<ClientDto> findAllClients() {
        log.info("Handling find all client request");
        return clientService.getAllClients();
    }

    @DeleteMapping("/{id}/removeRequest")
    public void removeRequest(@PathVariable Integer id,
                              @RequestBody RequestDto requestDto) throws ServiceException {
        log.info("Request was deleted: " + requestDto.getRequest_text());
        clientService.removeRequest(id, requestDto);
    }

    @GetMapping("/{id}/getMyRequests")
    public List<RequestDto> getMyRequests(@PathVariable Integer id) throws ServiceException {
        log.info("Your requests: ");
        return clientService.getMyRequests(id);
    }
}
