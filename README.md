
````markdown
#  Notification System

A Spring Boot application built as part of a Java internship. It allows **admin users** to manage **customers**, their **addresses**, and **notification preferences** (Email, SMS, Push).

---

##  Tech Stack

- Java 17
- Spring Boot 3
- Spring Security (admin login)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Thymeleaf
- Lombok
- Maven

---

##  Features

-  Secure admin login with bcrypt
-  Full customer CRUD
-  1:1 embedded address form
-  Notification preferences (Email, SMS, Push)
-  Facade pattern for business logic encapsulation
- ️ Server-side validation and error messages
-  PostgreSQL persistence
-  Thymeleaf UI templates

---

## 🔍 UI Preview

### 🔐 Login Page
![Login](![chrome_smuYJPirxM](https://github.com/user-attachments/assets/f8f5fdb1-18f5-4667-9d88-b30e83c183a9)
)

### 🏠 Dashboard
![Dashboard](screenshots/dashboard.png)
![chrome_IxMpE9kRHO](https://github.com/user-attachments/assets/bf670473-5e25-451e-a879-75f34459fc1d)

### ➕ Create Customer
![Create Customer](screenshots/create_customer.png)
![chrome_wnM89Z0cEw](https://github.com/user-attachments/assets/82550d56-62e0-4909-ae5c-1d889b7b6a0f)

### ✏️ Edit Customer
![Edit Customer](screenshots/edit_customer.png)
![chrome_CV5VfgmKX4](https://github.com/user-attachments/assets/4de03664-7736-4c54-9c1c-3702c5a9c966)

### 📋 Customer List
![Customer List](screenshots/customer_list.png)
![chrome_9pN0LHO2qi](https://github.com/user-attachments/assets/bca256e9-bd88-43da-a202-1af26ea15041)


--

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/python1911/notificationsystem.git
cd notificationsystem
````

### 2️⃣ Set Up PostgreSQL

- Create a PostgreSQL database named `notification_db`.

- Update your database credentials in `src/main/resources/application.properties`:


```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/notification_db
spring.datasource.username=postgres
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Insert Admin Credentials

Using `psql` or pgAdmin:

```sql
INSERT INTO users (username, password, role, enabled) VALUES (
  'admin',
  '$2a$10$p81l4m2ZpmBa5BTOLakn7.e8DS.Pgkye27u9qRHEWHUf716Enj.jq', -- password: admin123
  'ADMIN',
  true
);
```

### 4️⃣ Run the Application

Use IntelliJ or the command line:

```bash
./mvnw spring-boot:run
```

---

##  Admin Login

- **Username:** `admin`

- **Password:** `admin123`


---

## Project Structure

```
notificationsystem/
├── controller/                # MVC controllers
├── entity/                    # JPA entity models
├── facade/                    # Business logic layer (Facade Pattern)
├── repository/                # Spring Data interfaces
├── config/                    # Spring Security configuration
├── templates/                 # Thymeleaf HTML templates
└── NotificationsystemApplication.java   # Main entry point
```

---

##  Design Highlights

- `@Builder`, `@Valid`, and `@Transactional` annotations used where appropriate

- `Address` entity embedded using `@OneToOne` relationship

- `NotificationPreference` entity stores SMS/Email/Push flags

- `CustomerManagementFacade` cleanly separates controller and repository logic

- Spring Security restricts access to authenticated users only

- Thymeleaf forms include validation messages and error handling




