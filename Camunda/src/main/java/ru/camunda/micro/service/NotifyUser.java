package ru.camunda.micro.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class NotifyUser implements JavaDelegate {

    private final String HELLO_MESSAGE = "%s, Welcome!";

    private final String REJECT_MESSAGE = "%s, You have been denied access";

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
