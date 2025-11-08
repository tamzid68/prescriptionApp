# Prescription Management System

A robust and secure Spring Boot application for managing patient prescriptions, built with modern Java and Spring
technologies.

## 🚀 Features

- **Patient Prescription Management**: Create, read, update, and delete prescriptions
- **Reporting**: Generate prescription reports with date filters
- **RESTful API**: Fully documented endpoints following REST principles
- **Data Validation**: Comprehensive input validation and error handling
- **Security**: Built-in authentication and authorization
- **Database**: H2 in-memory database with file persistence

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.5.7
- **Database**: H2 Database (in-memory with file persistence)
- **Build Tool**: Maven
- **API Documentation**: SpringDoc OpenAPI
- **Testing**: JUnit 5, Mockito
- **Validation**: Bean Validation 3.0
- **Security**: Spring Security

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- Git (optional)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/prescription-app.git
   cd prescription-app
   ```

2. **Build the application**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

## 📚 API Documentation

Once the application is running, you can access the following:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI Documentation**: `http://localhost:8080/v3/api-docs`
- **H2 Console**: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:file:./data/prescription-db`)

### Available Endpoints

#### Prescription Management

- `GET /api/v1/prescriptions` - Get all prescriptions (with optional date filters)
- `GET /api/v1/prescriptions/{id}` - Get a specific prescription
- `POST /api/v1/prescriptions` - Create a new prescription
- `PUT /api/v1/prescriptions/{id}` - Update an existing prescription
- `DELETE /api/v1/prescriptions/{id}` - Delete a prescription

#### Reporting

- `GET /api/v1/prescriptions/report` - Generate prescription reports

## 🗄️ Database Schema

The application uses H2 database with the following main entities:

- **Prescription**: Stores prescription details
- **Patient**: Patient information
- **Medication**: Medication details
- **Doctor**: Prescribing doctor information

## 🛡️ Security

The application includes:

- JWT-based authentication
- Role-based access control
- Password encryption
- CSRF protection
- Input validation and sanitization

## 🧪 Testing

Run the test suite with:

```bash
mvn test
```

## 🌐 Deployment

### Production Build

```bash
mvn clean package -DskipTests
java -jar target/prescriptionApp-0.0.1-SNAPSHOT.jar
```

### Docker

```bash
docker build -t prescription-app .
docker run -p 8080:8080 prescription-app
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
