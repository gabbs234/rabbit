## RABBIT 

A task manager REST API built with Spring Boot, secured with JWT authentication, backed by PostgreSQL and containerized with Docker and deployed on Render.

Live Demo:

https://rabbit-ejyl.onrender.com

(N/B: Hosted on free tier)

## Features

- User registration and login
- Stateless authentication with JWT (access token sent in the Authrorization header)
- Create and list tasks, persisted in PostgreSQL
- Passwords hashed and routes protected with Spring Security
-  Automated tests
- Dockerized and deployed with a managed Render PostgreSQL database
- Secrets and configuration supplied through environment variables 

## Tech Stack

---------------------------------------------
| Language | Java 17/21                     |
|----------|--------------------------------|
| Framework | Spring Boot, Spring Data JPA  |
|----------|--------------------------------|
| Security | Spring Security, JWT(jjwt)     | 
|----------|--------------------------------|
| Database | PostgreSQL                     |
|----------|--------------------------------|
| Build    | Maven
|----------|--------------------------------|
| Other    | Lombok, Docker
|----------|--------------------------------|
| Hosting | Render                          |
---------------------------------------------

 ## API Endpoints

 -----------------------------------------------------
| Method | Path         | Auth  | Description        |
|--------|--------------|----------------------------|
| POST   | /auth/register| No    | Create a new user |
|--------|------------------------------------------|
| POST   | /auth/register| No    | Create a new user
|----------|--------------------------------|
| GET | PostgreSQL                     |
|----------|--------------------------------|
| POST    | Maven
|----------|--------------------------------|
| Other    | Lombok, Docker
|----------|--------------------------------|
| Hosting | Render                          |
---------------------------------------------
