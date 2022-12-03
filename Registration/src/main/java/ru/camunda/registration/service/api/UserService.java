package ru.camunda.registration.service.api;

import ru.camunda.registration.controller.dto.UserCreateRequest;
import ru.camunda.registration.controller.dto.UserResponse;
import ru.camunda.registration.entity.UserEntity;

public interface UserService {

    UserResponse createUser(UserCreateRequest userCreateRequest);

    UserEntity findUserEntity(Integer id);

    void approveUser(Integer id);
}
