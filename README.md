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

 
| Method | Path | Auth | Description |
|--------|------|------|-------------|
| POST | `/auth/register` | No | Create a new user |
| POST | `/auth/login` | No | Log in and receive a JWT |
| GET | `/tasks` | Yes | List tasks |
| POST | `/tasks` | Yes | Create a task |

## Example

Register a user:
`curl -X POST https://rabbit-ejyl.onrender.com/auth/register -H "Content-Type: application/json" -d '{"username":"john", "password":"secret123"}'`

Login and copy token from response:

```bash
curl -X POST https://rabbit-ejyl.onrender.com/auth/login -H "Content-Type: application/json" -d '{"username":"john", "password":"secret123"}'
```

Create a task:

```bash
curl -X POST https://rabbit-ejyl.onrender.com/tasks
  -H "Authorization: Bearer YOUR_TOKEN" 
  -H "Content-Type: application/json" 
  -d '{"title": "Write my README"}'
```
List tasks:

```bash
curl  https://rabbit-ejyl.onrender.com/tasks
  -H "Authorization: Bearer YOUR_TOKEN"
```

## Run Locally

### Prerequisites

- JDK 21
- Maven
- PostgreSQL

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/gabbs234/rabbit.git
   cd rabbit
   ```

2. Create a PostgreSQL database named `rabbit`.

3. Set the environment variables:

   | Variable | Description |
   |----------|-------------|
   | `DB_URL` | JDBC URL, e.g. `jdbc:postgresql://localhost:5432/rabbit` |
   | `DB_USERNAME` | Database user |
   | `DB_PASSWORD` | Database password |
   | `JWT_SECRET` | Secret key used to sign tokens |

   *(Adjust these names to match your `application.properties`.)*

4. Run the app:

   ```bash
   mvn spring-boot:run
   ```

   The API will be available at `http://localhost:8080`.

### Run with Docker

```bash
docker build -t rabbit .
docker run -p 8080:8080 \
  -e DB_URL=... -e DB_USERNAME=... -e DB_PASSWORD=... -e JWT_SECRET=... \
  rabbit
```

## Tests

```bash
mvn test
```

## Future Improvements

- Update and delete endpoints for tasks
- Task ownership so each user only sees their own tasks
- Pagination and filtering (by status, due date)
- API documentation with Swagger/OpenAPI

## Author

Built by gabbs234 as a learning project in Spring Boot and backend development.
