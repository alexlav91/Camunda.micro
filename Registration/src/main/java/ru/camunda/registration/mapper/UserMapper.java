package ru.camunda.registration.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.camunda.registration.config.MappersConfig;
import ru.camunda.registration.controller.dto.UserCreateRequest;
import ru.camunda.registration.controller.dto.UserResponse;
import ru.camunda.registration.entity.UserEntity;

@Mapper(config = MappersConfig.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "approved", constant = "false")
    UserEntity toEntity(UserCreateRequest userCreateRequest);

    UserResponse toRespond(UserEntity userEntity);
}
