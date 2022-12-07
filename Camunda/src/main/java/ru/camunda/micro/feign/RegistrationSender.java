package ru.camunda.micro.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.name}",url = "${feign.url}")
public interface RegistrationSender {

    @RequestMapping(method = RequestMethod.POST, value = "/approve", consumes = "application/json")
    void sendStartMessage(Integer id);
}
