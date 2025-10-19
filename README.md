
**💻 Smart Banking Management System**

A Java-based web application that simulates essential banking operations — including secure user registration, balance management, and transaction tracking.
Built using **Spring MVC**, **Hibernate (JPA)**, **MySQL**, **JSP**, and **Servlets**.

---

### 🚀 Features

* Secure user registration and login
* Credit and debit transaction management
* Automatic transaction history logging
* User ↔ Transaction mapping with JPA annotations
* Database integration using Hibernate ORM and MySQL

---

### 🧩 Tech Stack

* **Frontend:** JSP, HTML, CSS, Bootstrap
* **Backend:** Java, Spring MVC, Hibernate (JPA)
* **Database:** MySQL
* **Server:** Apache Tomcat
* **IDE:** Eclipse IDE
* **Build Tool:** Maven

---

### 🏗️ Project Structure

```
SmartBankingManagementProject/
├── src/main/java/com/smartbanking/
│   ├── controller/        # Spring MVC controllers
│   ├── model/             # Entity classes (User, Transaction, etc.)
│   ├── service/           # Business logic layer
│   └── dao/               # DAO interfaces and implementations
├── src/main/webapp/
│   ├── WEB-INF/
│   │   └── views/         # JSP pages (login.jsp, register.jsp, dashboard.jsp, etc.)
│   └── resources/         # CSS, JS, and other static files
├── pom.xml                # Maven dependencies
└── README.md              # Project documentation
```

---

### ⚙️ Setup & Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/SmartBankingManagementProject.git
   ```

2. **Import into Eclipse**

   * Open Eclipse IDE
   * Go to `File → Import → Existing Maven Project`
   * Select the cloned folder

3. **Configure Database**

   * Create a MySQL database named `smartbankingdb`
   * Update credentials in `application.properties` or `hibernate.cfg.xml`

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/smartbankingdb
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     ```

4. **Run the Project**

   * Deploy on Apache Tomcat (v9 or above)
   * Access the app at: [http://localhost:8080/SmartBankingManagementProject](http://localhost:8080/SmartBankingManagementProject)

---

### 🧠 Learning Highlights

* Implemented MVC architecture for clean separation of layers
* Mapped User–Transaction relationship using JPA annotations
* Applied Hibernate ORM for database operations
* Focused on real-world banking use cases

---

### 👨‍🏫 Acknowledgment

Special thanks to **Fayaz S (FLM EduTech)** for guidance and mentorship during this project.

---

### ✨ Author

**Developed by:** Sajja Ajay
*MCA Student | Java Full Stack Developer in Progress*
Guided by **FLM EduTech**

---
