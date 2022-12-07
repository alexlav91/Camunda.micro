Camunda.micro
---------
Описание:
---------
Camunda.micro - приложение для регистрации пользователя с
дальнейшим подтверждением регистрации администратором и выводом лога о
результатах регистрации в консоль.

---------
Назначение и цель создания
---------
Тестовое задание

----
Установка
------
Проект разворачивается с использованием:
1. Язык программирования Java 17 версии
2. База данных для сервиса Camunda (по умолчанию H2)
3. База данных для сервиса Registration (по умолчанию H2)
4. Фреймворк Spring Boot
5. Сборщик проекта Maven
6. Camunda-Api


Для настройки приложения требуется:

-Camunda service:

1. Прописать данные для администратора Camunda и, по необходимости, для фильтрации:
    ```
   camunda:
     bpm:
      admin-user:
       id: demo
       password: demo
       filter:
        create: All tasks
    ```
2. Прописать переменные среды для базы данных для сервиса Camunda:
   ```
   spring:
     datasource:
       driver-class-name: org.h2.Driver
       url: jdbc:h2:file:./camunda-h2-database

   ```
3. Указать данные для feign клиента:
   ```
   #feign.name
   feign.name: ${CAMUNDA_SERVICE_NAME:registration}
   #feign.url=camunda
   feign.url: ${CAMUNDA_SERVICE_URL:http://localhost:8081}
   ```
4. Указать данные порта и имя приложения:
      ```
   spring:
        application:
           name: camunda
   server:
        port: 8080
      ```



-Registration service:
1. Создать базу данных, прописать переменные среды:
   ```
   spring.datasource.url=${REGISTRATION_DB_URL:jdbc:postgresql://localhost:5432/user_registration}
   spring.datasource.username=${REGISTRATION_DB_USERNAME:postgres}
   spring.datasource.password=${REGISTRATION_DB_PASSWORD:postgres}
   spring.datasource.driver-class-name=${REGISTRATION_DB_DRIVER:org.postgresql.Driver}
   spring.jpa.database-platform=${REGISTRATION_DB_PLATFORM:org.hibernate.dialect.PostgresPlusDialect}
   spring.jpa.hibernate.ddl-auto=update
   ```
2. Указать данные для feign клиента:
   ```
   #feign.name
   feign.name=${CAMUNDA_SERVICE_NAME:camunda}
   #feign.url
   feign.url=${CAMUNDA_SERVICE_URL:http://localhost:8080}
   ```
3. Указать данные порта и имя приложения:
   ```
   spring.application.name= registration
   server.port=8081
   ```
   


        
    






