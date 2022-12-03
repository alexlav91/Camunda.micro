package ru.camunda.registration.controller.mvc;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.camunda.registration.controller.dto.UserCreateRequest;
import ru.camunda.registration.service.api.UserService;

@Controller("UserMVC")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping()
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new UserCreateRequest());
        return "user/new_user";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") @Valid UserCreateRequest userCreateRequest,
                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user/new_user";
        }
        userService.createUser(userCreateRequest);
        return "redirect:/";
    }

    @GetMapping("/problem")
    public String ErrorPage() {
        return "error";
    }


}
