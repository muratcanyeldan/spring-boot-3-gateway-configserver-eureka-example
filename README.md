# Spring Boot 3 Microservices Example

This project demonstrates a microservices architecture using Spring Boot 3, Spring Cloud Gateway, Config Server, and Netflix Eureka for service discovery.

## Project Architecture

The application consists of the following components:

- **Config Server**: Centralized configuration for all services
- **Eureka Server**: Service discovery and registration
- **Cloud Gateway**: API Gateway that routes requests to appropriate services
- **Inventory Service**: Manages inventory items and stock

## Technology Stack

- Java 21
- Spring Boot 3
- Spring Cloud (Gateway, Config, Netflix Eureka)
- MySQL Database
- Docker & Docker Compose
- Maven

## Getting Started

### Running with Docker Compose

The easiest way to run the application is using Docker Compose:

```bash
# Clone the repository
git clone https://github.com/muratcanyeldan/spring-boot-3-gateway-configserver-eureka-example.git
cd spring-boot-3-gateway-configserver-eureka-example

# Start all services
docker-compose up
```

This will start:
- MySQL database
- Config Server (port 8088)
- Eureka Server (port 8761)
- Cloud Gateway (port 8090)
- Inventory Service (port 5001)

### Accessing the Services

- **Eureka Dashboard**: http://localhost:8761
- **Config Server**: http://localhost:8088
- **API Gateway**: http://localhost:8090
- **Inventory Service** (through Gateway): http://localhost:8090/api/v1/...

## API Endpoints

### Inventory Service

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /api/v1/inventory | Get current inventory |
| GET    | /api/v1/item/all | Get all items |
| POST   | /api/v1/inventory/add | Add item to inventory |
| POST   | /api/v1/item/create | Create new item |

### Request/Response Examples

#### Create New Item
```bash
# Request
POST http://localhost:8090/api/v1/item/create
Content-Type: application/json

{
    "itemName": "headphone",
    "description": "for listening music"
}
```

#### Add Item to Inventory
```bash
# Request
POST http://localhost:8090/api/v1/inventory/add
Content-Type: application/json

{
    "itemName": "headphone",
    "quantity": 1
}
```

## Project Structure

```
.
├── CloudGateway/           # API Gateway Service
├── ConfigServer/           # Configuration Server
│   └── src/main/resources/config/  # Centralized configurations
├── EurekaServer/           # Service Discovery
├── InventoryService/       # Inventory Microservice
├── postman-collection/     # API Collection for testing
└── docker-compose.yml      # Docker Compose configuration
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.