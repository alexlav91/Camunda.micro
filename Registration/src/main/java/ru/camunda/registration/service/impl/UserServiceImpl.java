package ru.camunda.registration.service.impl;


import feign.RetryableException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.camunda.registration.controller.dto.UserCreateRequest;
import ru.camunda.registration.controller.dto.UserResponse;

import ru.camunda.registration.exceptions.CamundaOfflineException;
import ru.camunda.registration.feign.Event;
import ru.camunda.registration.entity.UserEntity;
import ru.camunda.registration.exceptions.UserNotFoundException;
import ru.camunda.registration.mapper.UserMapper;
import ru.camunda.registration.repositoru.UserRepository;
import ru.camunda.registration.service.api.UserService;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final Event event;



    @Override
    @Transactional
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        UserEntity userEntityForSave = userMapper.toEntity(userCreateRequest);
        UserResponse userResponse = userMapper.toRespond(userRepository.save(userEntityForSave));
            try { event.sendStartMessage(userResponse);
            } catch (RetryableException ex) {
                throw CamundaOfflineException.create();
            }

        return userResponse;
    }

    @Override
    public UserEntity findUserEntity(Integer id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->
                UserNotFoundException.createById(id));
        return userEntity;
    }

    @Override
    public void approveUser(Integer id) {
        UserEntity userEntity = findUserEntity(id);
        userEntity.setApproved(true);
        userRepository.save(userEntity);
        log.info("User {} is approved", userEntity.getFullName());
    }
}
