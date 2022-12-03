package ru.camunda.micro.service.api;

import ru.camunda.micro.controller.dto.UserResponse;

public interface CamundaService {

    void startEvent(UserResponse userResponse);
}
