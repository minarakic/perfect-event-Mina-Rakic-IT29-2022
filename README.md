# Perfect Event – DevOps Project

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=minarakic_perfect-event-Mina-Rakic-IT29-2022&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=minarakic_perfect-event-Mina-Rakic-IT29-2022)

Microservices-based platform for planning and managing events.

## Architecture

The system is implemented using a microservices architecture.
Each service is responsible for a specific domain of the application.

Services included:

* **User Service** – manages users
* **Event Service** – manages events
* **Booking Service** – handles event bookings
* **Notification Service** – sends notifications
* **API Gateway** – central entry point for all requests

## Technologies Used

* Java 17
* Spring Boot
* Spring Cloud Gateway
* Gradle
* REST APIs

## System Architecture

Client requests are sent through the **API Gateway**, which routes them to the appropriate microservice.

Example:

Client → API Gateway → User Service

## Running the Application

Each microservice runs as a separate Spring Boot application.

Example endpoints:

User Service
http://localhost:8080/users

Event Service
http://localhost:8081/events

Booking Service
http://localhost:8082/bookings

API Gateway
http://localhost:8085

## Example Request (through API Gateway)

GET
http://localhost:8085/users
