package ru.camunda.registration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.camunda.registration.controller.dto.UserResponse;

@FeignClient(name = "${feign.name}",url = "${feign.url}")
public interface Event {

    @RequestMapping(method = RequestMethod.POST, value = "/send_event_message", consumes = "application/json")
    void sendStartMessage(UserResponse userResponse);
}
