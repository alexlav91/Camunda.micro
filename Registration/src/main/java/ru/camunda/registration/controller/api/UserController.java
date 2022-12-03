package ru.camunda.registration.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.camunda.registration.service.api.UserService;

@RestController
@RequestMapping("/approve")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    void approveUser(@RequestBody Integer id){
        userService.approveUser(id);
    }

}
