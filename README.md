# 🍬 Sweet Shop Management System – Backend

This repository contains the **backend implementation** of the **Sweet Shop Management System**, developed using **Java Spring Boot**.  
The backend acts as the core of the application, providing secure RESTful APIs for authentication, sweet management, and inventory operations.

The project follows **clean coding practices** and uses **Test-Driven Development (TDD)** for core business logic.

---

## 📌 Project Overview

The Sweet Shop Management System backend is responsible for:
- Managing users with secure authentication
- Handling sweets inventory and availability
- Supporting purchase and restock operations
- Enforcing role-based access (USER / ADMIN)
- Providing APIs for a frontend SPA (React)

The backend is designed to be scalable, testable, and easy to integrate with a modern frontend application.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- User registration and login
- JWT-based authentication
- Role-based access control (USER / ADMIN)

### 🍭 Sweet Management
- Add new sweets
- View all available sweets
- Update sweet details
- Delete sweets (Admin only)
- Search sweets by name, category, or price range

### 📦 Inventory Management
- Purchase sweets (decreases quantity)
- Restock sweets (Admin only)
- Prevents purchase when stock is insufficient

### 🧪 Testing
- Unit tests written using **JUnit 5** and **Mockito**
- Core service logic developed using **TDD (Red–Green–Refactor)**
- Clear, descriptive commit history showing TDD workflow

---

## 🛠️ Tech Stack (Backend)

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- JUnit 5 & Mockito
- Lombok

---

## 📂 Project Structure

```
sweet-shop-backend/
│
├── src/
│   ├── main/
│   │   ├── java/com/sweetshop/
│   │   │   ├── SweetShopApplication.java
│   │   │   │
│   │   │   ├── config/
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── JwtAuthFilter.java
│   │   │   │   └── CorsConfig.java
│   │   │   │
│   │   │   ├── auth/
│   │   │   │   ├── controller/
│   │   │   │   │   └── AuthController.java
│   │   │   │   ├── service/
│   │   │   │   │   └── AuthService.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── RegisterRequest.java
│   │   │   │   │   └── LoginRequest.java
│   │   │   │   ├── model/
│   │   │   │   │   ├── User.java
│   │   │   │   │   └── Role.java
│   │   │   │   └── repository/
│   │   │   │       └── UserRepository.java
│   │   │   │
│   │   │   ├── sweets/
│   │   │   │   ├── controller/
│   │   │   │   │   └── SweetController.java
│   │   │   │   ├── service/
│   │   │   │   │   └── SweetService.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── SweetRequest.java
│   │   │   │   │   └── SweetResponse.java
│   │   │   │   ├── model/
│   │   │   │   │   └── Sweet.java
│   │   │   │   └── repository/
│   │   │   │       └── SweetRepository.java
│   │   │   │
│   │   │   ├── inventory/
│   │   │   │   ├── controller/
│   │   │   │   │   └── InventoryController.java
│   │   │   │   ├── service/
│   │   │   │   │   └── InventoryService.java
│   │   │   │   └── dto/
│   │   │   │       └── PurchaseRequest.java
│   │   │
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── schema.sql / data.sql (optional)
│   │
│   ├── test/
│   │   ├── java/com/sweetshop/
│   │   │   ├── auth/
│   │   │   │   └── AuthServiceTest.java
│   │   │   ├── sweets/
│   │   │   │   └── SweetServiceTest.java
│   │   │   ├── inventory/
│   │   │   │   └── InventoryServiceTest.java
│   │   │
│   │   └── resources/
│   │       └── application-test.properties
│
├── pom.xml
└── README.md
```


---

## ⚙️ Setup & Run Locally (Backend)

### 1️⃣ Prerequisites
- Java 17 or higher
- Maven
- PostgreSQL
- IntelliJ IDEA (recommended)

---

### 2️⃣ Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE sweetshop;
Update application.properties:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/sweetshop
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your_jwt_secret_key
3️⃣ Run the Application
Using IntelliJ:

Open the project

Run SweetshopApplication.java

Or via terminal:

bash
Copy code
mvn spring-boot:run
The backend will start at:

arduino
Copy code
http://localhost:8080
🔌 API Endpoints
🔐 Auth
POST /api/auth/register

POST /api/auth/login

🍭 Sweets (Protected)
GET /api/sweets

POST /api/sweets

PUT /api/sweets/{id}

DELETE /api/sweets/{id} (Admin only)

📦 Inventory (Protected)
POST /api/sweets/{id}/purchase

POST /api/sweets/{id}/restock (Admin only)

🧪 Running Tests
bash
Copy code
mvn test
Tests validate service-layer business logic

Mockito is used to mock dependencies

Tests were written following TDD principles

📸 Screenshots
Screenshots of the application in action (API testing via Postman / Thunder Client) will be added here:

User registration and login
<img width="1470" height="353" alt="Screenshot 2025-12-14 at 1 40 36 PM" src="https://github.com/user-attachments/assets/bf7f56da-070c-4d4f-9881-64ced4466de9" />
<img width="1470" height="266" alt="Screenshot 2025-12-14 at 1 41 46 PM" src="https://github.com/user-attachments/assets/57fa3f12-fe67-4d1f-ab56-66a067814332" />
Fetching sweets
<img width="1453" height="788" alt="Screenshot 2025-12-14 at 1 45 00 PM" src="https://github.com/user-attachments/assets/cecb382f-d72c-48ea-a8cf-7bd927b5dc76" />
Purchasing a sweet
<img width="320" height="338" alt="Screenshot 2025-12-14 at 1 46 01 PM" src="https://github.com/user-attachments/assets/384ca680-e809-4c0f-ad8c-886d8cb20697" />
Restocking inventory (Admin)
<img width="1468" height="877" alt="Screenshot 2025-12-14 at 1 46 41 PM" src="https://github.com/user-attachments/assets/c5818c23-d4ca-4713-b78b-055e1e928e52" />
🤖 My AI Usage
AI Tools Used
ChatGPT

How AI Was Used
To clarify concepts such as Test-Driven Development (TDD), Mockito annotations, and JWT authentication flow.

To get guidance on project structure, clean architecture, and REST API design best practices.

To generate small boilerplate examples for test setup and configuration, which were then manually reviewed and adapted.

To improve commit message clarity and maintain a visible TDD-oriented Git history.

How AI Was NOT Used
AI was not used to generate complete business logic or full feature implementations.

Core backend logic, validations, API behavior, and debugging were implemented manually.

All tests were executed, analyzed, and fixed by me to ensure correctness and understanding.

Reflection
AI acted as a supportive learning and productivity tool, helping reduce repetitive setup work and clarify concepts. All architectural decisions and functional implementations were consciously designed, implemented, and understood by me.

📌 Notes
The frontend is implemented separately using React.

This repository focuses exclusively on backend API development and testing.

👤 Author
Subhojit Ghosh
BE – Computer Science & Engineering
