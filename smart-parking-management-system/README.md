<img width="1902" height="966" alt="Screenshot 2026-08-16 164852" src="https://github.com/user-attachments/assets/d22bd737-283f-4fee-8864-8212de36baae" />



# Smart Parking Management System (SPMS)

Microservice-based backend application for ITS 1018 – Software Architectures & Design Patterns II.

## Services

| Service | Port |
|---|---:|
| Eureka Server | 8761 |
| Config Server | 8888 |
| API Gateway | 8080 |
| User Service | 8081 |
| Vehicle Service | 8082 |
| Parking Service | 8083 |
| Payment Service | 8084 |

## Requirements
- Java 21
- Maven 3.9+
- MySQL 8 (only required for the business services)
- Postman

## Run order
1. eureka-server
2. config-server
3. user-service
4. vehicle-service
5. parking-service
6. payment-service
7. api-gateway

The business services in this starter project use in-memory storage so the project can be run immediately without database setup. MySQL dependencies are included for extension.

## Eureka
Open http://localhost:8761

## Gateway
Base URL: http://localhost:8080

## Resources
- [Postman Collection](./postman_collection.json)
- ![Eureka Dashboard](./docs/screenshots/eureka_dashboard.png)
