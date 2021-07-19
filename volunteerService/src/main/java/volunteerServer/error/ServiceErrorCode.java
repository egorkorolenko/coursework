package volunteerServer.error;

import java.io.Serializable;

public enum ServiceErrorCode implements Serializable {

    OBJECT_CANNOT_BE_NULL("Объект не может быть пустым"),
    INVALID_LOGIN("Неверный логин"),
    LOGIN_NOT_FOUND("Логин не найден");
    private final String errorString;

    ServiceErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

}
