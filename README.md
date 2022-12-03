Camunda.micro
---------
��������:
---------
Camunda.micro - ���������� ��� ����������� ������������ �
���������� �������������� ����������� ��������������� � ������� ���� �
����������� ����������� � �������.

---------
���������� � ���� ��������
---------
�������� �������

----
���������
------
������ ��������������� � ��������������:
1. ���� ���������������� Java 15 ������
2. ���� ������ ��� ������� Camunda (�� ��������� H2)
3. ���� ������ ��� ������� Registration (�� ��������� H2)
4. ��������� Spring Boot
5. ������� ������� Maven
6. Camunda-Api


��� ��������� ���������� ���������:

-Camunda service:

1. ��������� ������ ��� �������������� Camunda �, �� �������������, ��� ����������:
    ```
   camunda:
     bpm:
      admin-user:
       id: demo
       password: demo
       filter:
        create: All tasks
    ```
2. ��������� ���������� ����� ��� ���� ������ ��� ������� Camunda:
   ```
   spring:
     datasource:
       driver-class-name: org.h2.Driver
       url: jdbc:h2:file:./camunda-h2-database

   ```
3. ������� ������ ��� feign �������:
   ```
   #feign.name
   feign.name: ${CAMUNDA_SERVICE_NAME:registration}
   #feign.url=camunda
   feign.url: ${CAMUNDA_SERVICE_URL:http://localhost:8081}
   ```
4. ������� ������ ����� � ��� ����������:
      ```
   spring:
        application:
           name: camunda
   server:
        port: 8080
      ```



-Registration service:
1. ������� ���� ������, ��������� ���������� �����:
   ```
   spring.datasource.url=${REGISTRATION_DB_URL:jdbc:postgresql://localhost:5432/user_registration}
   spring.datasource.username=${REGISTRATION_DB_USERNAME:postgres}
   spring.datasource.password=${REGISTRATION_DB_PASSWORD:postgres}
   spring.datasource.driver-class-name=${REGISTRATION_DB_DRIVER:org.postgresql.Driver}
   spring.jpa.database-platform=${REGISTRATION_DB_PLATFORM:org.hibernate.dialect.PostgresPlusDialect}
   spring.jpa.hibernate.ddl-auto=update
   ```
2. ������� ������ ��� feign �������:
   ```
   #feign.name
   feign.name=${CAMUNDA_SERVICE_NAME:camunda}
   #feign.url
   feign.url=${CAMUNDA_SERVICE_URL:http://localhost:8080}
   ```
3. ������� ������ ����� � ��� ����������:
   ```
   spring.application.name= registration
   server.port=8081
   ```
   


   
   
   
        
    






