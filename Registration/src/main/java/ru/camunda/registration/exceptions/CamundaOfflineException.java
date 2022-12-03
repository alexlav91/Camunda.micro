package ru.camunda.registration.exceptions;

public class CamundaOfflineException extends RuntimeException {
    
    protected CamundaOfflineException (String message) { super(message);}

    private final static String OFFLINE_MESSAGE = "Ой, все упало, скоро мы все поправим";

    public static CamundaOfflineException create(){
        return new CamundaOfflineException(OFFLINE_MESSAGE);
    }



}
