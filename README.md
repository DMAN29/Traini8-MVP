# Traini8-MVP

## Project Setup Instructions

### Prerequisites

- Install Java 17 or later
- Install Maven
- Install MongoDB (Local or Cloud)
- Install an IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Clone the Repository

```sh
    git clone https://github.com/DMAN29/Traini8-MVP.git
    cd Traini8-MVP
```

### Configure MongoDB

Update the `application.properties` file with your MongoDB connection details:

```properties
spring.application.name=Traini8-MVP
server.port=5000
spring.data.mongodb.database=timeStudy
spring.data.mongodb.uri=your_mongodb_uri_here
```

**Note:** MongoDB will automatically create the database when the first write operation occurs.

### Build and Run the Project

```sh
mvn clean install
mvn spring-boot:run
```

### API Endpoints

#### Add a Training Center

```http
POST http://localhost:5000/training-center
```

**Request Body:**

```json
{
  "centerName": "ABC Training Center",
  "centerCode": "ABC123XYZ789",
  "address": {
    "detailedAddress": "123 Main Street",
    "city": "Noida",
    "state": "Uttar Pradesh",
    "pincode": "201301"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot"],
  "contactEmail": "abc@example.com",
  "contactPhone": "9876543210"
}
```

**Response:**

```json
{
  "id": "65d1a3e8c2b47d001b3e1234",
  "centerName": "ABC Training Center",
  "centerCode": "ABC123XYZ789",
  "address": {
    "detailedAddress": "123 Main Street",
    "city": "Noida",
    "state": "Uttar Pradesh",
    "pincode": "201301"
  },
  "studentCapacity": 200,
  "coursesOffered": ["Java", "Spring Boot"],
  "contactEmail": "abc@example.com",
  "contactPhone": "9876543210"
}
```

#### Get Training Centers (Filtered Examples)

**Filter by City:**

```http
GET http://localhost:5000/training-center?city=Noida
```

**Response:**

```json
[
  {
    "id": "65d1a3e8c2b47d001b3e1234",
    "centerName": "ABC Training Center",
    "centerCode": "ABC123XYZ789",
    "address": {
      "detailedAddress": "123 Main Street",
      "city": "Noida",
      "state": "Uttar Pradesh",
      "pincode": "201301"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "abc@example.com",
    "contactPhone": "9876543210"
  }
]
```

**Filter by Student Capacity:**

```http
GET http://localhost:5000/training-center?studentCapacity=100
```

**Response:**

```json
[]
```

**Filter by Course Offered:**

```http
GET http://localhost:5000/training-center?course=Java
```

**Response:**

```json
[
  {
    "id": "65d1a3e8c2b47d001b3e1234",
    "centerName": "ABC Training Center",
    "centerCode": "ABC123XYZ789",
    "address": {
      "detailedAddress": "123 Main Street",
      "city": "Noida",
      "state": "Uttar Pradesh",
      "pincode": "201301"
    },
    "studentCapacity": 200,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "abc@example.com",
    "contactPhone": "9876543210"
  }
]
```

### Running Tests

To run tests:

```sh
mvn test
```

### License

This project is licensed under the MIT License.

