package lern.javacourse.studentOrder.exception;

public class CityRegisterException extends Exception{
    /*
    Когда я хочу создать класс описывающий какую-то проблему, ошибку ТО этот класс будет наследоваться от Exception
     */

    private String code;

    public CityRegisterException() {
    }

    public CityRegisterException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
