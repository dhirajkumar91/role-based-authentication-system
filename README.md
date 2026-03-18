# 🔐 Auth Service (Spring Boot + React)

A full-stack authentication system with **Role-Based Access Control (RBAC)** built using **Spring Boot (Backend)** and **React (Frontend)**.
This project supports secure login, registration, JWT authentication, and admin approval workflows.

---

## 🚀 Features

### 🔑 Authentication

* User Registration & Login
* JWT-based authentication
* Secure password hashing (Spring Security)

### 👥 Role-Based Access Control (RBAC)

* Roles: `USER`, `ADMIN`
* Protected routes based on roles
* Admin-only APIs

### 🌐 Frontend (React)

* Login & Register UI
* API integration with backend
* Simple and clean structure

---

## 🛠️ Tech Stack

### Backend

* Java 17+
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Maven

### Frontend

* React (Vite)
* Axios
* CSS

---

## 📁 Project Structure

```
auth-service/
  ├── src/main/java/com/demo/auth/
  │   ├── config/
  │   ├── controller/
  │   ├── dto/
  │   ├── entity/
  │   ├── repository/
  │   ├── service/
  │   └── AuthServiceApplication.java
  └── application.properties

auth-frontend/
  ├── src/
  │   ├── pages/
  │   ├── services/
  │   └── App.jsx
```

---

## ⚙️ Setup Instructions

### 🔹 Backend Setup

```bash
cd auth-service
mvn clean install
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

### 🔹 Frontend Setup

```bash
cd auth-frontend
npm install
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

## 🔐 API Endpoints

### Auth APIs

* `POST api/v1//auth/register` → Register user
* `POST api/v1/auth/login` → Login user
  
---

## 📌 Future Improvements

* Refresh Tokens
* Email verification (OTP)
* Role management UI
* Pagination & filters
* Deployment (Docker + Cloud)

---

## 👨‍💻 Author

**Dhiraj Kumar**
MERN Stack & Java Developer

---

## ⭐ Contribution

Feel free to fork, improve, and contribute to this project!

---

## 📜 License

This project is open-source and available under the MIT License.
