# Training Center Management System

This project is a Spring Boot application that integrates with MongoDB to manage training centers.

## Prerequisites

- Java 17 or later
- Maven 3.6+
- MongoDB (local or cloud)

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/DMAN29/Traini8-MVP.git
cd <your-project-folder>
```

### 2. Configure Application Properties
Edit `src/main/resources/application.properties`:
```properties
spring.application.name=Traini8-MVP
server.port=5000
spring.data.mongodb.database=timeStudy
spring.data.mongodb.uri=<your-mongodb-uri>
```
Replace `<your-mongodb-uri>` with your actual MongoDB connection string.

### 3. Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

### 4. API Endpoints

#### Add a Training Center
```http
POST /training-center
```
**Body (JSON Example):**
```json
{
  "centerName": "Tech Academy",
  "centerCode": "TCA1234567890",
  "address": {
    "detailedAddress": "123 Main Street",
    "city": "Noida",
    "state": "Uttar Pradesh",
    "pincode": "201301"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Spring Boot"],
  "contactEmail": "info@techacademy.com",
  "contactPhone": "9876543210"
}
```

#### Get All Training Centers
```http
GET /training-center
```
Supports optional filters like `centerName`, `city`, `state`, `pincode`, `course`, etc.

**Example Filtered Requests:**
- Get centers in Noida:
  ```http
  GET /training-center?city=Noida
  ```
- Get centers with student capacity of at least 50:
  ```http
  GET /training-center?studentCapacity=50
  ```
- Get centers offering Java:
  ```http
  GET /training-center?course=Java
  ```

### 5. Run with Docker
#### Build Docker Image
```sh
docker build -t training-center-app .
```
#### Run the Container
```sh
docker run -p 5000:5000 training-center-app
```

## Deployment
To deploy on a cloud service, configure your MongoDB URI and update `application.properties` accordingly.

---
For further support, contact the development team.

