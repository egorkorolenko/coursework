package volunteerServer.serviceUtils;

import volunteerServer.dto.VolunteerDto;
import volunteerServer.error.ServiceException;
import volunteerServer.error.ServiceErrorCode;

public class VolunteerUtils {
    public void validateDto(VolunteerDto volunteerDto) {
        if (volunteerDto == null) {
            try {
                throw new ServiceException(ServiceErrorCode.OBJECT_CANNOT_BE_NULL);
            } catch (ServiceException serviceException) {
                serviceException.printStackTrace();
            }
        }
    }

}
