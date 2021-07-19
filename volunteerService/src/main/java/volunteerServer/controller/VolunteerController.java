package volunteerServer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.error.ServiceException;
import volunteerServer.service.VolunteerService;

@Slf4j
@RestController
@RequestMapping("/volunteer")
@AllArgsConstructor
@Log
@CrossOrigin
public class VolunteerController {
    private final VolunteerService service;

    @PostMapping("/register")
    public VolunteerDto registerVolunteer(@RequestBody VolunteerDto volunteerDto) {
        log.info("Volunteer register: " + volunteerDto);
        return service.registerVolunteer(volunteerDto);
    }

//    @GetMapping("/getByLogin")
//    public VolunteerDto getByLogin(@RequestBody VolunteerDto volunteerDto) throws ServiceException {
//        log.info("Handling find by login request: " + volunteerDto.getLogin());
//        return service.getByLogin(volunteerDto.getLogin());
//    }

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

}
