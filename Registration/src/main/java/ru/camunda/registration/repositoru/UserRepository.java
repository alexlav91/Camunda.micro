package ru.camunda.registration.repositoru;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.camunda.registration.entity.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity, Integer> {
}
