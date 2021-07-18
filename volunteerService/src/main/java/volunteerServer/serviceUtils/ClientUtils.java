package volunteerServer.serviceUtils;

import volunteerServer.dto.ClientDto;
import volunteerServer.dto.VolunteerDto;
import volunteerServer.error.ServiceError;
import volunteerServer.error.ServiceErrorCode;

public class ClientUtils {
    public void validateDto(ClientDto clientDto) {
        if (clientDto == null) {
            try {
                throw new ServiceError(ServiceErrorCode.OBJECT_CANNOT_BE_NULL);
            } catch (ServiceError serviceError) {
                serviceError.printStackTrace();
            }
        }
    }
}