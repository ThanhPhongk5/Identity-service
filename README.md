# Identity Service

Identity Service is a backend system for managing user accounts.  
The project provides RESTful APIs for user registration, update, and retrieval.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven

## Features

- User registration
- Update user information
- Retrieve user details
- Global exception handling
- Layered architecture (Controller – Service – Repository)

## Project Structure

src
├── controller
├── service
├── repository
├── entity
├── dto
└── exception

## API Example

GET /users  
POST /users  
PUT /users/{id}

