# INTISG26JFAGN001_Team01-_Training-Management-System_CLI_REPO


# Training Management System (CLI)

A  Java-based Command Line Interface (CLI) application designed to manage educational courses, user registrations, and student enrollments. This project is a simple command line implementation.

---

## 📂 Project Structure

The project is organized under the root package `org.cognizant.TrainingManagementSystem`:

| Package | Description |
| :--- | :--- |
| **`Entity`** | Contains POJOs (Plain Old Java Objects) representing data models: `User`, `Course`, and `Enrollment`. |
| **`DAOs`** | Data Access Objects responsible for low-level CRUD operations and database interactions. |
| **`Service`** | The business logic layer that coordinates between the DAOs and the user interface. |
| **`DBConnection`** | A utility class for managing JDBC driver registration and database connectivity. |
| **`Main`** | The `TrainingManagementSystem.java` file serves as the application's entry point and CLI menu. |

---

## 🚀 Key Features

* **User Management**: Create and manage student or instructor profiles.
* **Course Administration**: Add, and list available training modules.
* **Enrollment Logic**:  enroll users into specific courses .
* **Persistence**: Data is persisted using JDBC (Java Database Connectivity).
* **Clean Architecture**: Separation of layers makes the code easy to test and extend.

---

## 🛠 Tech Stack

* **Language**: Java (JDK 11+)
* **Build Tool**: Maven
* **Database**: SQL-based (MySQL/PostgreSQL recommended)
* **IDE Support**: IntelliJ IDEA (includes `.idea` configuration)

---

## ⚙️ Setup & Installation

### 1. Prerequisites
* Ensure **Maven** is installed and added to your system PATH.
* A running instance of a SQL database.

### 2. Database Configuration
Open `src/main/java/org/cognizant/TrainingManagementSystem/DBConnection.java` and update your database credentials:

```java
private static final String URL = "jdbc:mysql://localhost:3306/training_db";
private static final String USER = "your_username";
private static final String PASS = "your_password";

3. Build the Project
Run the following command in the project root:

Bash
mvn clean install
4. Run the Application
You can start the CLI interface using:

Bash
mvn exec:java -Dexec.mainClass="org.cognizant.TrainingManagementSystem.TrainingManage
