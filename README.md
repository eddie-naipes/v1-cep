# 📖 V1-CEP

**V1-CEP** is a Spring Boot application for querying postal codes (CEPs) and fetching detailed location data from an external API. The application follows clean architecture principles and implements SOLID design for maintainability and scalability.

---

## 📜 How to Run the Project

### Prerequisites
Ensure you have the following installed on your system:
- **Docker & Docker Compose**
- **Java 21** for local development
- **Gradle** for building the project locally (optional)

### 🚀 Steps to Run the Application
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/v1-cep.git
   cd v1-cep
   ```

2. **Build the project**:
   Run the following command to build the application:
   ```bash
   ./gradlew build
   ```

3. **Run the application using Docker Compose**:
   Start the application and its dependencies:
   ```bash
   docker-compose up --build
   ```

4. **Access the API**:
   - **API Endpoint**: `http://localhost:8080/api/cep/{cep}`
   - **Example**:
     ```http
     GET http://localhost:8080/api/cep/01001000
     ```

5. **Run tests**:
   Execute unit and integration tests:
   ```bash
   ./gradlew test
   ```

---

## 🔗 API Endpoints

### `GET /api/cep/{cep}`
- **Description**: Fetches details about a postal code (CEP) from an external API and stores the query results in the database.
- **Path Parameter**:
   - `cep` (String): The postal code to be queried.
- **Response Example**:
  ```json
  {
    "cep": "01001000",
    "dataConsulta": "2025-01-14T14:44:45.166",
    "retornoApi": {
      "cep": "01001-000",
      "logradouro": "Praça da Sé",
      "complemento": "lado ímpar",
      "bairro": "Sé",
      "localidade": "São Paulo",
      "uf": "SP",
      "ibge": "3550308",
      "gia": "1004",
      "ddd": "11",
      "siafi": "7107"
    }
  }
  ```

---

## 🛠️ Architecture Overview

This project is built following **Clean Architecture** and **SOLID principles** to ensure modularity, scalability, and maintainability.

### 📂 Key Layers
1. **API Layer**:
   - Handles HTTP requests and responses.
   - Exposes the `GET /api/cep/{cep}` endpoint.
   - Uses DTOs to ensure a clean separation of input/output data.

2. **Domain Layer**:
   - Contains core business logic.
   - Includes the `BuscarCepUseCase`, responsible for querying CEPs and saving the results.

3. **Infrastructure Layer**:
   - Handles communication with external APIs (e.g., WireMock).
   - Manages database persistence through JPA repositories.
   - Configures shared dependencies like `RestTemplate` and database connections.

### ⚙️ Workflow
1. The **Controller** receives a request and delegates it to the **Use Case**.
2. The **Use Case**:
   - Fetches CEP details from the external API via the **Service**.
   - Saves the query results to the database using the **Repository**.
3. The response is formatted and returned to the client via the **Controller**.

---

## ⚙️ Configuration

The application's configuration is stored in `application.yaml`. Adjust the following properties as needed:

### 🛢️ Database Configuration
```yaml
spring:
  datasource:
    url: jdbc:postgresql://postgres:5433/mydatabase
    username: myuser
    password: secret
```

### 🌐 External API Configuration
```yaml
api:
  external:
    base-url: http://wiremock:8080
```

---

## ✅ Testing

- **Unit Tests**: Validate individual components like services and repositories.
- **Integration Tests**: Verify interactions between components and the database or external APIs.
- **Test Command**:
  ```bash
  ./gradlew test
  ```

---

## 🚀 Improvements to Consider

1. **Caching**: Add caching mechanisms (e.g., Redis) for frequently queried CEPs.
2. **Enhanced Error Handling**: Implement more robust exception handling and meaningful error messages.
3. **Monitoring**: Integrate tools like Prometheus and Grafana for performance monitoring.
4. **Frontend Integration**: Build a simple UI for querying CEPs.

---

## 📞 Contact

- **Developer**: [Edmilson](mailto:eddiasdev@gmail.com)
- **GitHub**: [https://github.com/eddie-naipes](https://github.com/eddie-naipes)

---
