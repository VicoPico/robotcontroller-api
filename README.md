# Robot Controller API

The **Robot Controller API** is a Spring Boot application that provides RESTful endpoints to control a robot navigating a grid-based room. This project is a refined version of a Java/Maven command-line application, now enhanced with a web-based API for easier integration and scalability.

---

## Table of Contents

- [Robot Controller API](#robot-controller-api)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Technologies Used](#technologies-used)
  - [How to Run Locally](#how-to-run-locally)
    - [Prerequisites](#prerequisites)
    - [Steps to Run Locally](#steps-to-run-locally)
  - [API Endpoints](#api-endpoints)

---

## Features

- Define custom room dimensions via REST API.
- Set the robot's starting position and orientation.
- Issue movement commands (`L` for left, `R` for right, `F` for forward).
- Retrieve the robot's current position and orientation.
- Visualize the grid state dynamically.

---

## Technologies Used

- **Java 17**: Core programming language.
- **Spring Boot**: Framework for building the RESTful API.
- **Maven**: Dependency management and build tool.
- **Docker**: Containerization for easy deployment.

---

## How to Run Locally

### Prerequisites

- **Java 17 or later** installed on your system.
- **Maven** installed for building the project.

### Steps to Run Locally

1. Clone the repository:

```bash
  git clone https://github.com/your-username/robot-controller-api.git
  cd robot-controller-api

```

2. Build the project:

```bash
mvn clean package

```

3. Run the application

```bash
java -jar target/robot-controller-api-1.0-SNAPSHOT.jar

```

4. Access the API: Open your browser or API client (e.g., Postman or curl) and navigate to http://localhost:8080/api.

## API Endpoints

1. Initialize Room

`POST /api/initialize`

Request Body:

```bash
{
  "width": 5,
  "height": 5
}

```

Response:

```bash
"Room initialized with dimensions: 5x5"

```

2. Set Robot's Starting Position

`POST /api/robot/start`

Request Body:

```bash
{
  "x": 2,
  "y": 2,
  "direction": "N"
}

```

Response:

```bash
"Robot initialized at position: (2, 2) facing N"

```

3. Issue Commands

`POST /api/robot/commands`

Request Body:

```bash
{
  "commands": "LFFR"
}

```

Response:

```bash
"Commands processed successfully. Robot is now at (0, 2) facing N"

```

4. Visualize Grid

`GET /api/grid`

Response:

```bash
[ ] [ ] [ ] [ ] [ ]
[ ] [ ] [ ] [ ] [ ]
[N] [ ] [ ] [ ] [ ]
[ ] [ ] [ ] [ ] [ ]
[ ] [ ] [ ] [ ] [ ]

```
