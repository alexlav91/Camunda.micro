package ru.camunda.micro.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.camunda.micro.controller.feign.RegistrationSender;
@Slf4j
@Component
@RequiredArgsConstructor
public class ApproveRegistration implements JavaDelegate {


    private final RegistrationSender registrationSender;

    private final String SUCCESS_REGISTRATION_MESSAGE = "User {} has been successfully registered";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        log.info(SUCCESS_REGISTRATION_MESSAGE,delegateExecution.getVariable("username"));


        Integer id = (Integer) delegateExecution.getVariable("userId");

        registrationSender.sendStartMessage(id);

    }
}
