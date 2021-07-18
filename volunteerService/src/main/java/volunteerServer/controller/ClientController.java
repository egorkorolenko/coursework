package volunteerServer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import volunteerServer.dto.ClientDto;
import volunteerServer.service.ClientService;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Log
@CrossOrigin
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/register")
    public ClientDto registerVolunteer(@RequestBody ClientDto clientDto) {
        log.info("Volunteer register: " + clientDto);
        return clientService.registerClient(clientDto);
    }
}
