
# FetchMeSeats

A resilient, event-driven microservices backend designed to handle high-concurrency flight seat reservations.

---

## Architecture Overview

The system is split into various microservices communicating via REST and asynchronous messaging:

* **Inventory Service:** Manages seat configurations and maps across 3 cabin classes (Economy, Premium Economy, Business).
* **Booking Service:** Handles incoming reservation requests and state transitions using an even
* **Order Service:** Manages payment confirmation and ticket issuing.


---

## Features

* Event-driven architecture using Apache Kafka, to prevent race conditions.
* Authentication and authorization implemented using Keycloak for OAuth2/OIDC authentication.
* Database versioning and schema evolution using Flyway.

---

## Tech Stack

* **Core Framework:** Java, Spring Boot, Spring Cloud
* **Messaging:** Apache Kafka
* **Resilience:** Resilience4j
* **Security:** Keycloak, Spring Security, OAuth2 / JWT
* **Database and versioning:** MySQL, Spring Data JPA, Flyway
* **Build and containerization:** Maven, Docker, Docker Compose

---

## API Endpoints

### Order Service

| Endpoint | Method | Description | Path Variables |
| --- | --- | --- | --- |
| `/order/{orderId}` | `GET` | Retrieve detailed order and reservation info | `orderId` (Long) |

---

### Inventory Service

| Endpoint | Method | Description | Path Variables / Payload |
| --- | --- | --- | --- |
| `/inventory/zones` | `GET` | List every inventory zone in every cabin class | None |
| `/inventory/zone/{zoneId}` | `GET` | Fetch specific zone availability details | `zoneId` (Long) |
| `/inventory/flight/{flightId}` | `GET` | Fetch complete inventory for a flight | `flightId` (Long) |
| `/inventory/zone/{zoneId}/capacity/{capacity}` | `PUT` | Update seat capacity for a zone | `zoneId` (Long), `capacity` (Long) |

---

### Booking Service

| Endpoint | Method | Description | Request Body |
| --- | --- | --- | --- |
| `/booking` | `POST` | Initiate a new seat reservation request | `BookingRequest` (JSON) |
