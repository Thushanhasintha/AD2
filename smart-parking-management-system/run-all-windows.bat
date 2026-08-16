@echo off
echo Start each service in a separate terminal in this order:
echo 1. cd eureka-server ^&^& mvnw spring-boot:run
echo 2. cd config-server ^&^& mvnw spring-boot:run
echo 3. cd user-service ^&^& mvnw spring-boot:run
echo 4. cd vehicle-service ^&^& mvnw spring-boot:run
echo 5. cd parking-service ^&^& mvnw spring-boot:run
echo 6. cd payment-service ^&^& mvnw spring-boot:run
echo 7. cd api-gateway ^&^& mvnw spring-boot:run
echo.
echo If mvnw is not available, use: mvn spring-boot:run
pause
