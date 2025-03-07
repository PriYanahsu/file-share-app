# File Sharing Application

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
- **Database**: MySQL (for storing user and file data)
- **Authentication**: OAuth (GitHub & Google login integration)
- **API Requests**: REST APIs (for fetching and sending data)
- **Frontend**: Thymeleaf (for rendering dynamic pages in Spring Boot)

## Project Structure

```
File-Sharing-App/
│── src/
│   ├── main/
│   │   ├── java/com/example/filesharing/
│   │   │   ├── configration/   # mount the all workings
│   │   │   ├── controllers/    # Handles API requests
│   │   │   ├── services/       # Business logic
│   │   │   ├── repositories/   # Database interaction
│   │   │   ├── models/         # models
│   │   │   ├── entity/         # entity
│   │   │   ├── exception/      # handle exceptions
│   │   ├── resources/templates/
│   │   │   ├── home.html      # Home page for file upload & sharing
│   │   │   ├── listfiles.html      # Authentication page
|   |   |   ├── share-files.html     # to share file and download
│   │   ├── resources/static
│   │   │   ├── red.jpg   # image 1
│   │   │   ├── blue.jpg  # image 2
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

### 1. Entry dynamic Frontend page
![Screenshot (322)](https://github.com/user-attachments/assets/1c39c942-ab67-4089-8fba-6a8ec699cb2b)

### 2. Login with GitHub or Google or id - user && password - 1111
![Screenshot (313)](https://github.com/user-attachments/assets/92029fe0-0353-424f-98ce-49de6be1358a)

### 3. File Management Interface
![Screenshot (316)](https://github.com/user-attachments/assets/397f48c4-8264-446f-845d-e460ff22da09)

### 4. File uploaded you can delete and share 
![Screenshot (317)](https://github.com/user-attachments/assets/70102e82-353e-496e-b600-68fe82cfbf5c)

### 4. Shareable File Link
![Screenshot (318)](https://github.com/user-attachments/assets/f144eba4-c514-4fd0-90e8-ade894808d47)

### 5. Download it also
![Screenshot (319)](https://github.com/user-attachments/assets/c1471eee-fe2f-4665-bf12-965066cdac83)

## Additional Features
- **Drag & Drop Upload**: Easily upload files by dragging them into the upload box.
- **File Expiration**: Within 24 hours file will be deleted from my code you can add to yourself also.
- **Download Tracking**: Track who has accessed the shared file.
- **Multiple File Formats**: Supports images, PDFs, documents, and more.
- **User Dashboard**: View and manage all uploaded files in one place.

## Contributing
If you’d like to contribute, feel free to fork the repository and submit a pull request with improvements!

## License
This project is licensed under the **MIT License**.
