# Backend - Registration Service (Spring Boot)

This is the backend API for user registration, built using Spring Boot and PostgreSQL.

---

## 🚀 Prerequisites

Make sure you have the following installed:

- [Java 17+](https://adoptium.net/en-GB/)
- [Maven](https://maven.apache.org/install.html)
- [PostgreSQL](https://www.postgresql.org/download/)

---

## 🐘 Setup Instructions

### 1. Install PostgreSQL

Download and install PostgreSQL from [https://www.postgresql.org/download/](https://www.postgresql.org/download/).

> During setup, **remember your PostgreSQL password** (you'll use it later in configuration).

---

### 2. Create Database

After installing PostgreSQL:

1. Open terminal (or pgAdmin).
```bash
# sudo -i -u postgres 
psql
```

2. Run the following to create a database:

```sql
create database registration;
-- output: CREATE DATABASE
```

3. Configure these information (username, password) in `/backend/src/main/resources/application.yaml`

If you forget your PostgreSQL password, try resetting it with the below code after `psql`.

```sql
ALTER USER postgres WITH PASSWORD '123456';
-- for this project demo code, the default password is `123456` 
```

## 🧪 Running and Testing the Backend via IDE
1. Open the project in an IDE like VSCode.

2. Ensure your IDE recognizes the project as a Maven project.

3. In the `src/main/java/com/example/demo folder`, navigate to `DemoApplication.java`.

4. Click the green ▶️ Run button next to the class name, or near the main function.

5. Wait for the console to display all, test the back end via visiting [localhost:8080/users/](http://localhost:8080/users/)


## 📦 Build Instructions

```bash
# Navigate to the backend directory
cd backend

# Build the Spring Boot project using Maven
./mvnw clean install
```


```bash
# Run the Spring Boot app
./mvnw spring-boot:run
```

and in a new terminal for front end:
```bash
# Navigate to the backend directory
cd frontend

# Build the Spring Boot project using Maven
npm run dev
```

The backend is now hosted at [localhost:8080](http://localhost:8080). The user database can be checked at [localhost:8080/users/](http://localhost:8080/users/)

The backend takes request from the frontend at [localhost:5173](http://localhost:5173)
