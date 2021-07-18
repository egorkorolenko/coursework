package volunteerServer.error;

import java.io.Serializable;

public enum ServiceErrorCode implements Serializable {

    OBJECT_CANNOT_BE_NULL("Объект не может быть пустым");;
    private final String errorString;

    ServiceErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

}
