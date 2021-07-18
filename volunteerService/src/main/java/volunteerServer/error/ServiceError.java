package volunteerServer.error;

import java.io.Serializable;

public class ServiceError extends Exception implements Serializable {
    private final ServiceErrorCode errorCode;

    public ServiceError(ServiceErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceErrorCode getErrorCode() {
        return errorCode;
    }

}
