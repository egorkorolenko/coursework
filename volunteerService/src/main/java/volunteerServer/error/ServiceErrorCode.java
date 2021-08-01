package volunteerServer.error;

import java.io.Serializable;

public enum ServiceErrorCode implements Serializable {

    OBJECT_CANNOT_BE_NULL("Объект не может быть пустым"),
    INVALID_LOGIN("Неверный логин"),
    INVALID_ID("Неверный ID"),
    LOGIN_NOT_FOUND("Логин не найден"),
    ID_NOT_FOUND("Id не найден"),
    INVALID_USERNAME("Некорректное имя"),
    INVALID_BIRTHDATE("Неверно задана дата рождения"),
    INVALID_EMAIL("Некорректный адрес электронной почты"),
    INVALID_PASSWORD("Неправльно задан пароль"),
    AGE_MUST_OVER_18_YEARS_OLD("Волонтером могут быть люди только старше 18 лет"),
    REQUEST_TEXT_INCORRECT("Некорректный текст запроса обслуживания"),
    ADDRESS_INCORRECT("Некорректный адрес"),
    CLIENT_NOT_FOUND("Клиент не найден"),
    INVALID_REPORT("Отчет некорректный");
    private final String errorString;

    ServiceErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }

}
