package volunteerServer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.service.VolunteerService;

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


}
