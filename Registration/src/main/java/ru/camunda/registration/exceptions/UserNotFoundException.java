package ru.camunda.registration.exceptions;

public class UserNotFoundException extends RuntimeException{

    protected UserNotFoundException(String message){ super(message);}

    private static final String USER_NOT_FOUND_MESSAGE = "Пользователь не найден, id: %s";

    public static UserNotFoundException createById(Integer id){
        String message = String.format(USER_NOT_FOUND_MESSAGE, id);
        return new UserNotFoundException(message);
    }
}
