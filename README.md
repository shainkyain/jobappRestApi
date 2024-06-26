﻿# jobappRestApi
Project Overview:
I am developing 'jobapp', a Spring Boot monolithic application serving as a REST API, with PostgreSQL as the backend database.

# Key Learning Areas:

**Monolithic Architecture**: Understanding how to structure and integrate services within a single application.

**Service Integration**: Connecting Job management, Company profiles, and Company Reviews through well-designed APIs.

**Actuators**: Utilizing Spring Boot Actuators to monitor and manage application health and metrics.

# Technological Stack:

Framework: Spring Boot

Database: PostgreSQL

API Design: RESTful principles

# Current Focus:

Configuring database connections

Refining API endpoints

Ensuring secure and efficient data management


# Future Development:

Implementing authentication and data caching

Exploring microservices architecture for scalability

Challenges and Solutions:

**Challenges**: Balancing monolithic simplicity with scalability

**Solutions**: Using modular design and strategic API architecture to maintain flexibility and ease of maintenance

# EndPoints

CompanyController

GET http://localhost:8080/companies

POST http://localhost:8080/companies

GET http://localhost:8080/companies/{id}

DELETE http://localhost:8080/companies/{id}

PUT http://localhost:8080/companies/{id}

JobController

GET http://localhost:8080/jobs

POST http://localhost:8080/jobs

GET http://localhost:8080/jobs/{id}

DELETE http://localhost:8080/jobs/{id}

PUT http://localhost:8080/jobs/{id}

ReviewController

GET http://localhost:8080/companies/{companyId}/reviews

POST http://localhost:8080/companies/{companyId}/reviews

GET http://localhost:8080/companies/{companyId}/reviews/{reviewId}

PUT http://localhost:8080/companies/{companyId}/reviews/{reviewId}

DELETE http://localhost:8080/companies/{companyId}/reviews/{reviewId}


# Conclusion:

The 'jobapp' project is a practical exploration of monolithic architecture, aimed at building a robust and scalable RESTful application.
