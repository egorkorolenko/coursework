//package com.example.volunteerservice.protype;
//
//import volunteerServer.dto.VolunteerDto;
//import volunteerServer.entity.Volunteer;
//
//public class VolunteerPrototype {
//
//    public static Volunteer aVolunteer() {
//        Volunteer volunteer = new Volunteer();
//        volunteer.setId(null);
//        volunteer.setUsername("Username Usernamov Usernamovich");
//        volunteer.setBirthdate("19.05.2000");
//        volunteer.setEmail("email@gmail.com");
//        volunteer.setLogin("TestLogin");
//        volunteer.setPassword("testPassword");
//        return volunteer;
//    }
//
//    public static VolunteerDto aVolunteerDTO() {
//        return VolunteerDto.builder()
//                .id(null)
//                .username("Username Usernamov Usernamovich")
//                .birthdate("19.05.2000")
//                .email("email@gmail.com")
//                .login("TestLogin")
//                .password("testPassword")
//                .build();
//    }
//}
