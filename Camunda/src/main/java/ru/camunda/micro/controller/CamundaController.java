package ru.camunda.micro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.camunda.micro.controller.dto.UserResponse;
import ru.camunda.micro.service.api.CamundaService;

@RestController
@RequestMapping("/send_event_message")
@RequiredArgsConstructor
public class CamundaController {

    private final CamundaService camundaService;

    @PostMapping()
    public void startEvent(@RequestBody UserResponse userResponse){
        camundaService.startEvent(userResponse);
    }


}
