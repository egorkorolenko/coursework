//package com.example.volunteerservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import volunteerServer.controller.VolunteerController;
//import volunteerServer.service.VolunteerService;
//
//import java.util.Collections;
//
//import static com.example.volunteerservice.protype.VolunteerPrototype.aVolunteerDTO;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class VolunteerControllerTest {
//
//    MockMvc mockMvc;
//    ObjectMapper objectMapper;
//    VolunteerService volunteerService;
//
//    @BeforeEach
//    void setUp() {
//        volunteerService = mock(VolunteerService.class);
//        mockMvc = MockMvcBuilders.standaloneSetup(new VolunteerController(volunteerService)).build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    public void registerVolunteerTest() throws Exception {
//        when(volunteerService.registerVolunteer(any())).thenReturn(aVolunteerDTO());
//        mockMvc.perform(post("/volunteer/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(aVolunteerDTO())))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(objectMapper.writeValueAsString(aVolunteerDTO())));
//    }
//
//    @Test
//    void findAllUsers() throws Exception {
//        when(volunteerService.getAllVolunteer()).thenReturn(Collections.singletonList(aVolunteerDTO()));
//        mockMvc.perform(get("/volunteer/findAll")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(aVolunteerDTO()))))
//                .andExpect(status().isOk());
//    }
//}
