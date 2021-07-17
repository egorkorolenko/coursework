package error;

import java.io.Serializable;

public enum ServiceErrorCode implements Serializable{

    ;
    private final String errorString;

    ServiceErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

}
