🏥 Medicine Inventory Management System (Spring Boot)

A secure web-based Medicine Inventory System built using Spring Boot + Thymeleaf + MySQL + JWT Authentication that allows admin management and viewer access with email notification support.

🚀 Features
👤 Authentication & Security

JWT-based login system

Role-based access:

ADMIN → Full CRUD access

VIEWER → Read-only access

Spring Security configured with CORS and CSRF handling

💊 Medicine Management

Add medicine

Edit medicine (Name, Price, Batch Number only)

Delete medicine

Update stock quantity

Update expiry date separately

List medicines with details:

ID

Name

Batch number

Expiry date

Price

Quantity

📧 Email Notification System

Automatic email alerts when:

Quantity gets updated

Expiry date is changed

Stock goes below threshold level

Implemented using JavaMailSender

🖥️ Modern UI

Thymeleaf-based UI

Bootstrap CSS

Clean dashboards

Role-based visibility

Admin control options hidden for viewers

🏗️ Tech Stack
Layer	Technology
Backend	Spring Boot
Frontend	Thymeleaf + HTML + CSS + Bootstrap
Database	MySQL
Security	Spring Security + JWT
Email	JavaMailSender
ORM	JPA + Hibernate
Build Tool	Maven
Version Control	Git, GitHub
📂 Project Structure
src
 ├── controller
 │     ├── AuthController
 │     ├── MedicineController
 │     ├── PageController
 │
 ├── service
 │     ├── MedicineService
 │     ├── EmailService
 │     ├── NotificationService
 │     ├── UserService
 │
 ├── security
 │     ├── JwtAuthenticationFilter
 │     ├── JwtUtil
 │     ├── SecurityConfig
 │     ├── CorsConfig
 │
 ├── repository
 │     ├── MedicineRepository
 │     ├── UserRepository
 │
 ├── entities
 │     ├── Medicine
 │     ├── AppUser
 │
 ├── dto
 │     └── UserDTO
 │
 └── resources
        ├── templates
        │     ├── login.html
        │     ├── register.html
        │     ├── dashboard.html
        │     ├── medicine-form.html
        │     ├── medicine-edit-form.html
        │
        └── static/css
              └── style.css

⚙️ Setup Instructions
🗄️ Database Configuration (MySQL)

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/medicine_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

📧 Mail Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=yourmail@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

▶️ Run Project

Using terminal:

mvn spring-boot:run


OR run directly from IDE.

🔐 Login Credentials

You may register users using:

Role: ADMIN

Role: VIEWER

Admins get full control, viewers only see data.

🧪 Sample Test Scenarios

✅ Add medicine
✅ Update quantity
✅ Update expiry → mail received
✅ Low stock alert
✅ Viewer cannot edit
✅ Admin can delete

📸 Screenshots (Optional)


✅ Future Improvements

Barcode scanning

Report export (PDF/Excel)

Admin analytics dashboard

Role management panel

Cloud email integration

👩‍💻 Author

Kaviya K
Java | Spring Boot | Backend Developer

GitHub: (Add your profile link)

🌟 Give a Star

If you like this project, don’t forget to ⭐ the repository!
