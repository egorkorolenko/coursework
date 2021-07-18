package volunteerServer.serviceUtils;

import volunteerServer.dto.VolunteerDto;
import volunteerServer.error.ServiceError;
import volunteerServer.error.ServiceErrorCode;

public class VolunteerUtils {
    public void validateVolunteerDto(VolunteerDto volunteerDto) {
        if (volunteerDto == null) {
            try {
                throw new ServiceError(ServiceErrorCode.OBJECT_CANNOT_BE_NULL);
            } catch (ServiceError serviceError) {
                serviceError.printStackTrace();
            }
        }
    }

}
