## SDAT + DevOps Sprint 1 – Spring Boot REST API

This project is a backend RESTful API built using **Spring Boot** that models a simple aviation system with cities, airports, aircraft, and passengers. It is part of a two-repository assignment: this is the **API (Server)** component.

---

## Features

- Exposes a REST API over HTTP using Spring Boot
- Persists data to **MySQL**
- Supports full **CRUD** operations for:
    - City
    - Airport
    - Aircraft
    - Passenger
- Models complex **relationships**:
    - A City has many Airports
    - A Passenger lives in one City and can fly on many Aircraft
    - An Aircraft can carry many Passengers and use many Airports (for takeoff/landing)
    - An Airport belongs to one City
- Includes **relationship query endpoints** to answer 4 required questions
- Can be tested easily using **Postman**

---

## API Endpoints

Standard REST endpoints:
- `GET /api/cities`, `POST /api/cities`, `PUT /api/cities/{id}`, `DELETE /api/cities/{id}`
- Similar endpoints exist for `/airports`, `/aircrafts`, and `/passengers`

Query endpoints:
- `GET /api/query/city-airports` → Airports in each city
- `GET /api/query/passenger-aircrafts` → Aircrafts flown by each passenger
- `GET /api/query/aircraft-airports` → Airports where aircrafts take off and land
- `GET /api/query/passenger-airports` → Airports used by passengers

---

## Tech Stack

- Java 17+
- Spring Boot 3
- Spring Data JPA
- MySQL
- Maven
- Lombok (for reducing boilerplate)
- JPA Annotations for ORM

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or newer
- MySQL installed and running
- Maven installed

### Setup

1. Clone the repo:

   ```
   git clone https://github.com/yourusername/SDAT-DevOps-Sprint1.git
   cd SDAT-DevOps-Sprint1
   
2. Configure MySQL connection in application.properties:

    ```
   spring.datasource.url=jdbc:mysql://localhost:3306/sdatdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   
3. 	Build and run the app:

    ```
   mvn clean install
   mvn spring-boot:run
   
---

## Testing With Postman
Use Postman to:
- Add, update, and delete records in each entity
- Test the 4 relationship-based queries in `/api/query/`

---

## Project Structure

```
src/
 └── main/
     └── java/com/example/sdat/
         ├── controller/
         ├── model/
         ├── repository/
         ├── service/
                └── impl/
         └── exception/
```

## Author

### Harini Manohar
SD-12 | Sem-4 | Sprint-1