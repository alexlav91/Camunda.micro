package ru.camunda.micro.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class NotifyUser implements JavaDelegate {

    private final String HELLO_MESSAGE = "%s, добро пожаловать на портал!";

    private final String REJECT_MESSAGE = "%s, Вам отказано в доступе";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        if((Boolean) delegateExecution.getVariable("decision")) {
            System.out.println(String.format(HELLO_MESSAGE,
                    delegateExecution.getVariable("username")));
        } else {
            System.out.println(String.format(REJECT_MESSAGE,
                    delegateExecution.getVariable("username")));
        }
    }
}
