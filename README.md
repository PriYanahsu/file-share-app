# File Sharing Application

## Live Demo
[Click here to access the live application](#)

## Overview
The **File Sharing Application** is a web-based platform that allows users to securely upload, store, and share files with others. The app features authentication via **GitHub and Google**, enabling users to manage their files with ease. Uploaded files can be shared via generated links, ensuring seamless access and downloads.

## Features
- **Secure File Upload**: Users can upload files and store them securely.
- **User Authentication**: Integrated login with **GitHub and Google**.
- **File Management**: Users can enter file names, organize uploads, and retrieve files anytime.
- **File Sharing**: Generate shareable links for others to download files.
- **Storage Management**: Track file sizes and manage storage.
- **Responsive Design**: Optimized for both desktop and mobile devices.

## Technologies Used
- **Backend**: Spring Boot (for handling API requests & storage management)
- **Database**: MySQL / PostgreSQL (for storing user and file data)
- **Authentication**: OAuth (GitHub & Google login integration)
- **API Requests**: REST APIs (for fetching and sending data)
- **Frontend**: Thymeleaf (for rendering dynamic pages in Spring Boot)

## Project Structure

```
File-Sharing-App/
│── src/
│   ├── main/
│   │   ├── java/com/example/filesharing/
│   │   │   ├── controllers/    # Handles API requests
│   │   │   ├── services/       # Business logic
│   │   │   ├── repositories/   # Database interaction
│   │   │   ├── models/         # Entity models
│   │   ├── resources/templates/
│   │   │   ├── index.html      # Home page for file upload & sharing
│   │   │   ├── login.html      # Authentication page
│   │   ├── resources/static/css/
│   │   │   ├── styles.css      # Custom styling for UI
│   │   ├── resources/application.properties  # Configuration
│── README.md                   # Project documentation (this file)
```

## How to Run the Project

### 1. Clone the Repository
```sh
git clone <repository-url>
cd File-Sharing-App
```

### 2. Set Up Database
Configure your database connection in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/file_sharing_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Application
```sh
mvn spring-boot:run
```

### 4. Open the App in Your Browser
```sh
http://localhost:8080
```

## Screenshots

### 1. Home Page - Upload and Share Files
![Home Page](#)

### 2. Login with GitHub or Google
![Authentication](#)

### 3. File Management Interface
![File Management](#)

### 4. Shareable File Link
![File Sharing](#)

## Additional Features
- **Drag & Drop Upload**: Easily upload files by dragging them into the upload box.
- **File Expiration**: Set expiry dates for shared links.
- **Download Tracking**: Track who has accessed the shared file.
- **Multiple File Formats**: Supports images, PDFs, documents, and more.
- **User Dashboard**: View and manage all uploaded files in one place.

## Contributing
If you’d like to contribute, feel free to fork the repository and submit a pull request with improvements!

## License
This project is licensed under the **MIT License**.
