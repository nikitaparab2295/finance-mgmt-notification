# Notification Service

The **Notification Service** receives alerts from the Expense Service whenever a budget exceeds a defined threshold.
It stores notifications in an H2 in-memory database and exposes REST APIs.

---

## Tech Stack

* Spring Boot 3.5.8
* Java + Gradle
* Spring Data JPA + H2
* Feign Client (optional)
* Springdoc OpenAPI
* Docker

---

## Run Locally

```bash
cd finance-mgmt-notification
./gradlew bootRun
```

**Service runs at:**
[http://localhost:8083](http://localhost:8083)

---

## API Documentation (Swagger)

* [http://localhost:8083/swagger-ui.html](http://localhost:8083/swagger-ui.html)
* [http://localhost:8083/v3/api-docs](http://localhost:8083/v3/api-docs)
* [http://localhost:8083/v3/api-docs.yaml](http://localhost:8083/v3/api-docs.yaml)

---

## APIs

* **POST** `/notifications`
* **GET** `/notifications?ownerId=`

---

## Docker

```bash
docker build -t notification .
docker-compose up
```

---

## H2 Console

URL: [http://localhost:8083/h2-console](http://localhost:8083/h2-console)
**JDBC URL:** `jdbc:h2:mem:notificationdb`
