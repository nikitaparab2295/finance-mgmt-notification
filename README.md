# Notification Service

The **Notification Service** receives alerts from the Expense Service  
whenever a budget exceeds a threshold.

Stores notifications in H2 and exposes REST APIs.

---

## 🚀 Tech Stack
- Spring Boot 3.5.8
- Java + Gradle
- Spring Data JPA + H2
- Feign Client (optional)
- Springdoc OpenAPI
- Docker

---

## ▶️ Run Locally

```bash
cd notification
./gradlew bootRun

Runs at:
👉 http://localhost:8083

📘 Swagger Docs
👉 http://localhost:8083/swagger-ui.html
👉 http://localhost:8083/v3/api-docs
👉 http://localhost:8083/v3/api-docs.yaml

📮 APIs
POST /notifications
GET /notifications?ownerId=

🐳 Docker
docker build -t notification .
docker-compose up

🗃️ H2 Console
👉 http://localhost:8083/h2-console

JDBC: jdbc:h2:mem:notificationdb