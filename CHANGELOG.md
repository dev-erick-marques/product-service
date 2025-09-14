# Changelog

All notable changes to this project will be documented in this file.  
This project adheres to [Semantic Versioning](https://semver.org/).

---

## [1.0.0] - 2025-09-14

### feat
- Added request and response DTOs for products
- Added mapper for converting between entities and DTOs
- Modified endpoints for listing, creating, and retrieving products by ID
- Implemented soft delete and restore for products
- Added endpoints for listing, creating, and retrieving categories by ID
- Added new migration files

### refactor
- Organized global error handling and shared DTOs
- Created a common package for shared error DTOs, exceptions, and GlobalExceptionHandler
- Modularized domains (product, category) with their own controllers, services, and DTOs
- GlobalExceptionHandler now handles both domain-specific and generic exceptions consistently
- Applied SRP for error handling and DTO management
- Added support for field validation errors with structured error list responses
- Ensured timestamps are in ISO 8601 UTC truncated to milliseconds

### chore
- Changed table IDs to UUID

---

## [0.1.0] - 2025-09-01

### feat
- Exposed more CRUD endpoints and service discovery with Consul
- Added endpoint to list/delete products by ID
- Added service mapping with Consul

### refactor
- Improved ProductService logic for better code optimization
- Added exceptions package

---

## [0.0.1] - 2025-08-28

### feat
- Exposed endpoint for creating and listing products
- Added POST and GET `/products` in the controller
- Added DTO, entity, service, and repository classes

---

## [0.0.0] - 2025-08-27

### chore
- Started microservices project
- Set up database
- Added migration files
- Created a simple controller endpoint for testing
