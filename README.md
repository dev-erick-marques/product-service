# Product Service

The **Product Service** is a modular microservice responsible for managing products in the **Elevare Commerce** platform.
It provides endpoints to create, list, update, and delete products. 

The service uses **Consul** for service discovery and requires a **JWT token** from the **Auth-Service**.

[Read in Portuguese](README-PT.md)

---
## Technologies
- Java 17+
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (JSON Web Token)
- OAuth2 Resource Server
- Maven
---
## JWT & Keys
All microservices (including Product Service) must use the same public key as the Auth-Service to validate JWT tokens.
- Make sure the public key is accessible to each service, either via environment variable or configuration file.
- The private key remains only in the Auth-Service for signing tokens.
- If you don’t have a key pair yet, you can generate one with this [project](https://github.com/Dev-Erick-Marques/rsa256-key-pair-generator).
- All endpoints are protected with JWT. Obtain a token from the [Auth Service](https://github.com/Dev-Erick-Marques/auth-service).
---
## Prerequisites

- Java 17+
- Consul running
- Auth-Service for JWT token generation
- Same public key as the auth service
---
## Consul Setup
1. Download Consul [here](https://developer.hashicorp.com/consul/install) 
2. Run in development mode: `consul agent -dev`
3. The Consul web UI will be available at ``localhost:8500``
---
##  Features

- Modular domains: Each domain (Product, Category) has its own controllers, services, and DTOs. 
- Shared global error handling: One GlobalExceptionHandler handles both domain-specific and generic exceptions.

- Structured error responses:
- Supports field-level validation errors with a list of errors. 
- ISO 8601 UTC timestamps truncated to milliseconds. 
- Consistent JSON format across domains. 
- Single Responsibility Principle (SRP):
- Handler builds error responses. 
- DTOs hold error details. 
- Domain modules remain isolated. 
- Validation support: Bean Validation (@Valid, @NotNull, etc.) automatically triggers structured 400 responses.

---
## Main Endpoints

### Products

| Method | Endpoint                   | Description                        |
|--------|----------------------------|------------------------------------|
| GET    | ``/products``              | List all products                  |
| POST   | ``/products  ``            | Create a new product               |
| GET    | ``/products/{id}``         | Get product by ID                  |
| DELETE | ``/products/{id}``         | Soft delete product by ID          |
| PATCH  | ``/products/{id}/restore`` | Restore soft deleted product by ID |

### Categories

| Method | Endpoint             | Description           |
|--------|----------------------|-----------------------|
| GET    | ``/categories``      | List all categories   |
| POST   | ``/categories``      | Create a new category |
| GET    | ``/categories/{id}`` | Get category by ID    |

---

## Next Steps

- Add validation so that when an item is soft-deleted, it does not appear in the product or category listings.
- Add endpoint to update products / categories
- Add endpoint to delete categories
- Implement role-based access for endpoints
---

## Notes
- If you want to choose another database, you must update the dependencies in the `pom.xml` to support Flyway
---
## Changelog
- See the [Changelog](CHANGELOG.md) for details of all changes.