package volunteerServer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Request;
import volunteerServer.error.ServiceException;
import volunteerServer.service.VolunteerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/volunteer")
@AllArgsConstructor
@Log
@CrossOrigin
public class VolunteerController {
    private final VolunteerService service;

    @PostMapping("/register")
    public VolunteerDto registerVolunteer(@RequestBody VolunteerDto volunteerDto) throws ServiceException {
        log.info("Volunteer register: " + volunteerDto);
        return service.registerVolunteer(volunteerDto);
    }


    @GetMapping("/findByLogin/{login}")
    public VolunteerDto findByLogin(@PathVariable String login) throws ServiceException {
        log.info("Handling find by login request: " + login);
        return service.findByLogin(login);
    }

    @GetMapping("/{id}")
    public VolunteerDto findById(@PathVariable Integer id) throws ServiceException {
        log.info("Handling find by login request: " + id);
        return service.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVolunteer(@PathVariable Integer id) throws ServiceException {
        VolunteerDto volunteerDto = findById(id);
        log.info("Volunteer : " + volunteerDto.getUsername() + " was deleted");
        service.deleteVolunteer(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findAll")
    public List<VolunteerDto> findAllVolunteer() {
        log.info("Handling find all volunteer request");
        return service.getAllVolunteer();
    }

    @GetMapping("/getClientRequests")
    public List<Request> getClientRequests() {
        log.info("customer requests have been received: ");
        return service.getClientRequest();
    }
}
