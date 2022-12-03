package ru.camunda.micro.service.impl;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;
import ru.camunda.micro.controller.dto.UserResponse;
import ru.camunda.micro.service.api.CamundaService;

@Service
@RequiredArgsConstructor
public class CamundaServiceImpl implements CamundaService {

    private final RuntimeService runtimeService;

    public void startEvent(UserResponse userResponse) {

        runtimeService.createMessageCorrelation("UserRegistered")
                .setVariable("username", userResponse.getFullName())
                .setVariable("userId", userResponse.getId())
                .correlate();

    }
}
