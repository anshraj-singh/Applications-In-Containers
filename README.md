# Applications in Containers

This repository is used as a long-term practice and experimentation space for building and running applications inside containers. I use this project to regularly apply what I learn, document commands, and track progress while working with backend systems and container-based workflows.

The goal is not to keep the project static, but to continuously improve it as new concepts are explored and implemented.

---

## Project Structure

```
RestDemo/
├── Dockerfile
├── pom.xml
├── src/
└── target/
    └── RestDemo-0.0.1-SNAPSHOT.jar
```

* `Dockerfile` : Used to build a Docker image for the application
* `src/` : Application source code
* `target/` : Build output generated after packaging the application

---

## Dockerfile

```dockerfile
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/RestDemo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
```

This Dockerfile:

* Uses a stable Java 21 base image
* Sets a working directory inside the container
* Copies the packaged application into the image
* Runs the application when the container starts

---

## How to Build and Run

Make sure Docker and Maven are installed and running on your system.

### 1. Move to project root

```bash
cd C:\Users\DELL\ideaProject\RestDemo
```

---

### 2. Build the application

```bash
mvn clean package
```

Verify that the JAR file is created:

```bash
dir target
```

You should see:

```
RestDemo-0.0.1-SNAPSHOT.jar
```

---

### 3. Build Docker image

```bash
   docker build -t ansh/rest-demo:v1 .
```

> Note: The `.` at the end is important. It tells Docker to use the current directory.

---

### 4. Verify Docker image

```bash
docker images
```

Confirm that `ansh/rest-demo:v1` exists in the list.

---

### 5. Run the container

```bash
  docker run -p 8080:8080 ansh/rest-demo:v1
```

The application will start inside a Docker container and listen on port 8080.

---

## Accessing the Application

Open a browser and visit:

```
http://localhost:8080
```

Use the appropriate endpoints defined in the application.

---

## Notes

* This repository is continuously updated as new concepts are learned
* Commands and configuration changes are intentionally documented here
* The focus is on hands-on experimentation and gradual improvement

---

## Future Additions

Planned improvements may include:

* Container optimization
* Multi-container setups
* Environment-based configurations
* Scaling and deployment experiments

---

## Purpose

This repository acts as a working reference and practice space where learning is backed by implementation, not just theory.

## Containerized Setup (Application + MongoDB)

This project is now fully containerized using Docker and Docker Compose.  
The application runs inside a container and connects to MongoDB **only via containers**, not a local database.

### Services Overview
- **Application** – Spring Boot REST app
- **MongoDB** – Database container
- **Mongo Express** – Web UI for MongoDB

---

## Prerequisites
- Docker
- Docker Compose
- Java & Maven (only for building the JAR)

---

## Build Application JAR
Run this before building Docker images:

```bash
mvn clean package
dir target
RestDemo-0.0.1-SNAPSHOT.jar
```

### Docker Compose Structure
```
rest-demo/
├── Dockerfile
├── docker-compose.yml
├── src/
├── target/
└── README.md
```
#### Build and start all services:
```bash
docker compose up --build
```

#### Run in background:
```bash
docker compose up -d
```

#### Stop all containers:
```bash
docker compose down
```

#### Verify Running Containers
```bash
  docker ps
```

You should see:

* rest-demo-app
* mongodb
* mongo-express
---
| Service       | URL                                            |
| ------------- | ---------------------------------------------- |
| Application   | [http://localhost:8080](http://localhost:8080) |
| Mongo Express | [http://localhost:8081](http://localhost:8081) |
| MongoDB       | localhost:27017                                |
---
## Notes
* No local database is used
* MongoDB data is persisted using Docker volumes
* This repository is used to practice container-based backend concepts 
* Future updates will include scaling, networking, and orchestration concepts 
* Fully Dockerized setup
* MongoDB runs inside a container
* Mongo Express used for database inspection
* No local database dependency
---

