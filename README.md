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

