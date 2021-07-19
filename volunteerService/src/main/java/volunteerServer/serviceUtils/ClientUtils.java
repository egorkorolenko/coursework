package volunteerServer.serviceUtils;

import volunteerServer.dto.ClientDto;
import volunteerServer.error.ServiceException;
import volunteerServer.error.ServiceErrorCode;

public class ClientUtils {
    public void validateDto(ClientDto clientDto) {
        if (clientDto == null) {
            try {
                throw new ServiceException(ServiceErrorCode.OBJECT_CANNOT_BE_NULL);
            } catch (ServiceException serviceException) {
                serviceException.printStackTrace();
            }
        }
    }
}