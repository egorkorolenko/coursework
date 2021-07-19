package volunteerServer.error;

import java.io.Serializable;

public class ServiceException extends Exception implements Serializable {
    private final ServiceErrorCode errorCode;

    public ServiceException(ServiceErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceErrorCode getErrorCode() {
        return errorCode;
    }

}
