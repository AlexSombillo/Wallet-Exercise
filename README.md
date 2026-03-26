## Wallet-Exercise (MAYA)
A backend service built with Spring Boot and Spring Data JPA that simulates a simple wallet system with the ability to send money between users, view balances, and track transaction history.
This project was developed as part of a backend coding assignment.

✨ Features
- User Account Management
- Create users tied to X-User-Id
- View wallet balance
- Send Money
- Transfer funds between users
- Transactions
- View transaction history
- External Integration
- Persistence
- Supports both H2 (in-memory)
- Logging

🛠️ Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 / Postgres
- Docker & Docker Compose
- Maven

## Setup & Run
1. Clone the repository
   git clone https://github.com/AlexSombillo/Wallet-Exercise
   cd send-money-app


2. Build the project
   mvn clean package


3. Run with Docker Compose
   docker-compose up --build


H2 (in-memory DB)
Update application.yml to use H2 profile:
mvn spring-boot:run -Dspring-boot.run.profiles=h2



## API Endpoints
|  |  |  |
| GET | /api/wallet/balance |  |
| POST | /api/wallet/send?recipientId={id}&amount={amt} |  |
| GET | /api/wallet/transactions |  |
| GET | /api/wallet/transactions/{id} |  |
| POST | /api/wallet/user?name={name}&initialBalance={amt} | X-User-Id |
| GET | /api/wallet/friends |  |


Note: All endpoints require the X-User-Id header.



