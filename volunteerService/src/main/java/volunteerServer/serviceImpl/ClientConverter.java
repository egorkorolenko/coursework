package volunteerServer.serviceImpl;

import volunteerServer.dto.ClientDto;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.entity.Client;
import volunteerServer.entity.Volunteer;

public class ClientConverter {
    public Client fromClientDtoToClient(ClientDto clientDto) {
        Client newClient = new Client();
        newClient.setId(clientDto.getId());
        newClient.setUsername(clientDto.getUsername());
        newClient.setBirthdate(clientDto.getBirthdate());
        newClient.setEmail(clientDto.getEmail());
        newClient.setLogin(clientDto.getLogin());
        newClient.setPassword(clientDto.getPassword());
        return newClient;
    }

    public ClientDto fromClientToClientDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .username(client.getUsername())
                .birthdate(client.getBirthdate())
                .email(client.getEmail())
                .login(client.getLogin())
                .password(client.getPassword())
                .build();
    }
}
