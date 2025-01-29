# 🌟 Job Management System

## 📝 Description

A robust Spring Boot application built with Clean Architecture principles, incorporating modern development practices and monitoring solutions.

## 🚀 Technologies & Tools

- [Spring Boot 3.4.2](https://spring.io/projects/spring-boot) - Java Framework
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - Programming Language
- [PostgreSQL 42.7.5](https://www.postgresql.org/) - Database
- [Spring Security](https://spring.io/projects/spring-security) - Security Framework
- [Java JWT 4.4.0](https://github.com/auth0/java-jwt) - JWT Implementation
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Persistence Framework
- [Lombok 1.18.36](https://projectlombok.org/) - Boilerplate Reduction
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/) - Input Validation
- [Spring DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools) - Development Tools
- [Swagger](https://swagger.io/) - API Documentation
- [Sonar Qube](https://www.sonarsource.com/products/sonarqube/) - High-Quality Code

## 🏗️ Architecture

Clean Architecture implementation with the following structure:

```
src/
└── main/
    └── java/
        ├── application/     # 🔧 Project configurations, error handling, and security
        ├── domain/         # 💼 Use cases and entities
        └── infrastructure/ # 🎮 Controllers and repositories
```

## 📋 Prerequisites

- ☕ Java 17 JDK
- 📦 Maven
- 🗄️ PostgreSQL

## 🚀 Getting Started

### 📥 Clone the Repository

```bash
git clone <repository-url>
cd job-management
```

### 💻 Running Locally

```bash
./mvnw spring-boot:run
```

## 🗄️ Database Configuration

Configure PostgreSQL connection in `application.properties`:

```properties
spring.application.name=job-management
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://localhost:5432/job-management
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

security.token.secret=secret-key
security.token.secret.candidate=secret-candidate
```

## 🔒 Security

The application uses Spring Security with JWT authentication:

- 🔑 JWT-based authentication (Auth0 JWT 4.4.0)
- 👥 Role-based access control
- 🔐 Secure password handling
- 🌐 CORS configuration

## 🧪 Testing

Run tests using:

```bash
./mvnw test
```

## 🧪 Sonar

Run Sonar Qube using:

```bash
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:9.9.0-community
```

## 🔧 Development Features

- Hot reload support with Spring DevTools
- Validation using Spring Validation
- Lombok for code reduction
- Comprehensive JWT implementation

Made with ❤️ by Diogo Soares
