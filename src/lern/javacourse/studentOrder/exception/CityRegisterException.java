package lern.javacourse.studentOrder.exception;

public class CityRegisterException extends Exception{
    /*
    Когда я хочу создать класс описывающий какую-то проблему, ошибку ТО этот класс будет наследоваться от Exception
     */

    public CityRegisterException() {
    }

    public CityRegisterException(String message) {
        super(message);
    }

    public CityRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
