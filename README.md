# Happy Programming System

## 📌 Introduction
This project is the final assignment of **Team G3** for the course *Java Servlet (SE1878)*.  
The **Happy Programming System**,is a software platform designed to facilitate online connections between mentors, mentees, and other actors involved in programming education.

This system replaces manual processes of coordinating mentorship and learning activities. Over time, it is envisioned to evolve into a robust ecosystem, integrating with online learning platforms, programming resources, and potentially third-party educational tools.

---

## 🛠️ Technologies
- **Language:** Java 17  
- **Framework:** Servlet/JSP, JSTL  
- **Database:** Microsoft SQL Server  
- **Frontend:** HTML5, CSS3, JavaScript (Bootstrap)  
- **Project Management:** Scrum (Iterations, Backlog, Project Tracking) 

---

## 🚀 Installation & Run

### 1. Requirements
- **JDK**: Java JDK 17  
- **IDE**: Apache NetBeans 17  
- **Server**: Apache Tomcat 10  
- **Database**: Microsoft SQL Server + SSMS  
- **JDBC Driver**: SQL Server JDBC Driver  

---

## 👥 Actors & Roles
- **Admin**: Manage skills, mentor accounts, and platform security.  
- **Manager**: Verify mentors, approve/reject CVs, track requests.  
- **Mentor**: Provide mentorship, manage profile & sessions.  
- **Mentee**: Hire mentors, send requests, attend sessions, give feedback.  
- **Guest**: Browse mentors before registering.  
- **VNPAY**: Secure payment gateway for transactions.  

---
## 📑 Documentation
The following documents are available in the `/docs` folder:

- [RDS Document](./docs/SE1878_JS(IT)_G3_RDS%20Document.docx)  or [Google Doc](https://docs.google.com/document/d/1eMxb17JljTpi5qU-Z_ZMiUs_WeRUZtOi/edit?usp=sharing&ouid=112876355383685662482&rtpof=true&sd=true) 
- [Final Release Document](./docs/SE1878_JS(IT)_G3_Final%20Release%20Document.docx)  or [Google Doc](https://docs.google.com/document/d/1eMxb17JljTpi5qU-Z_ZMiUs_WeRUZtOi/edit?usp=sharing&ouid=112876355383685662482&rtpof=true&sd=true)](https://docs.google.com/document/d/1XndCucQQx0H1XGRRG80zG4vLh9Bgf74L/edit?usp=sharing&ouid=112876355383685662482&rtpof=true&sd=true)  
- [Product Backlog](./docs/SE1878_JS(IT)_G3_Product%20Backlog.xlsx)  
- [Project Tracking](./docs/SE1878_JS(IT)_G3_HP_Project%20Tracking.xlsx)  
- [Database Schema (SQL)](./docs/DB_Final.sql)  
- [Final Presentation Slides](./docs/FinalProjectPresentation.pptx)  
## 🛠️ Setup Guide

#### (A) Install NetBeans 17
1. Go to [Apache NetBeans 17 Download](https://netbeans.apache.org/download/).  
2. Install and configure the IDE.  

#### (B) Install Java JDK 17
1. Download JDK 17 from [Oracle JDK Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).  
2. Run the installer and follow instructions.  
3. Set the `JAVA_HOME` environment variable.  

#### (C) Install & Configure SQL Server + SSMS
1. Download SQL Server Management Studio (SSMS) from [Microsoft SSMS Download](https://aka.ms/ssmsfullsetup).  
2. Install SQL Server from [Microsoft SQL Server Download](https://www.microsoft.com/en-us/sql-server/sql-server-downloads).  
3. Run the setup wizard and configure.  

#### (D) Install Apache Tomcat 10
1. Download from [Tomcat 10 Download](https://tomcat.apache.org/download-10.cgi).  
2. Extract the ZIP file to a directory (e.g., `C:\Tomcat`).  
3. Configure Tomcat in NetBeans:  
   - Open NetBeans → Tools → Servers → Add Server → Apache Tomcat.  
   - Select the extracted Tomcat directory.  

#### (E) Set Up JDBC Driver for SQL Server
1. Download [Microsoft JDBC Driver for SQL Server](https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server).  
2. Add JDBC driver to NetBeans:  
   - Tools → Libraries → New Library.  
   - Add the `.jar` file(s) from the JDBC driver.  

---

### 3. Database Setup
1. Open `docs/DB_Final.sql` in SQL Server Management Studio (SSMS).  
2. Execute the script to create the schema and insert sample data.  
3. Verify the database `HappyProgramming` has been created successfully.  
