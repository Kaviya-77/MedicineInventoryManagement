🏥 Medicine Inventory Management System (Spring Boot)

A secure web-based Medicine Inventory System built using Spring Boot + Thymeleaf + MySQL + JWT Authentication that allows admin management and viewer access with email notification support.

🚀 Features
The system automatically sends email notifications to the admin when a medicine’s stock quantity falls below 10, ensuring timely restocking and uninterrupted availability. Additionally, it sends expiry alerts when any medicine is within 30 days of its expiry date, helping prevent the use of expired products and ensuring inventory safety.
Authentication & Security
JWT-based login system
Role-based access:
ADMIN → Full CRUD access
VIEWER → Read-only access



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

Sample Test Scenarios
✅ Add medicine
✅ Update quantity
✅ Update expiry → mail received
✅ Low stock alert
✅ Viewer cannot edit
✅ Admin can delete

📸 Screenshots 
<img width="1912" height="852" alt="image" src="https://github.com/user-attachments/assets/2075b5e6-bff9-44a7-8cba-163b0d7ed0af" />
<img width="1810" height="736" alt="image" src="https://github.com/user-attachments/assets/1a441754-db4c-4f9c-8bc5-3c3c4ea6f4f1" />
<img width="1802" height="725" alt="image" src="https://github.com/user-attachments/assets/a5f957f4-8043-4875-93b5-55ae6f31558f" />
<img width="1796" height="733" alt="image" src="https://github.com/user-attachments/assets/14fa3b2d-302c-4980-b7ac-1f197994a8a9" />
<img width="1804" height="731" alt="image" src="https://github.com/user-attachments/assets/c8880c9c-db5c-4d3a-b1a4-dfd38455b15c" />
<img width="1811" height="735" alt="image" src="https://github.com/user-attachments/assets/1e34a45f-d707-4b3f-a417-470af83cad40" />
<img width="1813" height="735" alt="image" src="https://github.com/user-attachments/assets/3afbaf75-2fd9-40e2-9336-758ade1eb82e" />

🎬 Project Demo (Google Drive)
https://drive.google.com/file/d/1Qmx5eWRZNMUedauUYvIvG-Dsv5gbxt3z/view?usp=sharing

🌟 Give a Star
If you like this project, don’t forget to ⭐ the repository!
