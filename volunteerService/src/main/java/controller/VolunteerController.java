package controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceImpl.ClientServiceImpl;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
@Log
@CrossOrigin
public class VolunteerController {
    private final ClientServiceImpl service;

}
