package ru.camunda.micro.service;


import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.camunda.micro.controller.feign.RegistrationSender;

@Component
@RequiredArgsConstructor
public class ApproveRegistration implements JavaDelegate {


    private final RegistrationSender registrationSender;

    private final String SUCCESS_REGISTRATION_MESSAGE = "[%s] User %s has been successfully registered";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println(String.format(SUCCESS_REGISTRATION_MESSAGE,
                ApproveRegistration.class.getName(),
                delegateExecution.getVariable("username")));

        Integer id = (Integer) delegateExecution.getVariable("userId");

        registrationSender.sendStartMessage(id);

    }
}
