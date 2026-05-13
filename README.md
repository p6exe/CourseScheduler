# Course Scheduling Application
 
A desktop application for managing and scheduling courses, built in Java using Java Swing with NetBeans' GUI Builder. The app connects to a local MySQL database to store and retrieve course data.
 
---
 
## Features
 
- Add, update, and delete courses
- View and manage course schedules
- Persistent data storage via MySQL
- Clean GUI built with NetBeans' drag-and-drop GUI builder
---
 
## Requirements
 
- [Java JDK 8+](https://www.oracle.com/java/technologies/downloads/)
- [MySQL 9.6+](https://dev.mysql.com/downloads/mysql/)
- [MySQL Connector/J (JDBC Driver)](https://dev.mysql.com/downloads/connector/j/)
---
 
## Setup & Installation
 
### 1. Clone the repository
```
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
```
 
### 2. Download the MySQL JDBC Driver
- Go to [dev.mysql.com/downloads/connector/j](https://dev.mysql.com/downloads/connector/j)
- Download the ZIP and extract the `mysql-connector-j-x.x.x.jar` file
- Move the JAR file to the **root folder** of the project
Your project structure should look like this:
```
your-project/
├── src/
│   ├── MainFrame.java
│   └── ...
├── mysql-connector-j-9.7.0.jar
└── run.bat
```
 
### 3. Configure your database connection
Open your database connection file and make sure the credentials match your local MySQL setup:
```java
String url = "jdbc:mysql://localhost:3306/courseScheduler";
String user = "root";
String password = ""; // leave empty if no password is set
```
 
### 4. Run the application
Double-click `run.bat` or from the command prompt in the project root:
```
run.bat
```
This will automatically create the `courseScheduler` database if it doesn't exist, compile the source files, and launch the application.
 
---
 
## Built With
 
- Java Swing
- NetBeans GUI Builder
- MySQL
- JDBC (MySQL Connector/J)
---
 
## Author
 
Richard Huang — [github.com/p6exe](https://github.com/p6exe)
