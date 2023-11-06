<div align="center">
<h1 align="center">
<img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" />
<br>CHILLS-APP-BACKEND</h1>
<h3>◦ Powering Chills App-Unleashing boundless creativity!</h3>
<h3>◦ Developed with the software and tools below.</h3>

<p align="center">
<img src="https://img.shields.io/badge/YAML-CB171E.svg?style=flat-square&logo=YAML&logoColor=white" alt="YAML" />
<img src="https://img.shields.io/badge/Python-3776AB.svg?style=flat-square&logo=Python&logoColor=white" alt="Python" />
<img src="https://img.shields.io/badge/Docker-2496ED.svg?style=flat-square&logo=Docker&logoColor=white" alt="Docker" />
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white" alt="java" />
</p>
<img src="https://img.shields.io/github/license/CMoreno04/Chills-App-Backend?style=flat-square&color=5D6D7E" alt="GitHub license" />
<img src="https://img.shields.io/github/last-commit/CMoreno04/Chills-App-Backend?style=flat-square&color=5D6D7E" alt="git-last-commit" />
<img src="https://img.shields.io/github/commit-activity/m/CMoreno04/Chills-App-Backend?style=flat-square&color=5D6D7E" alt="GitHub commit activity" />
<img src="https://img.shields.io/github/languages/top/CMoreno04/Chills-App-Backend?style=flat-square&color=5D6D7E" alt="GitHub top language" />
</div>

---

## 📖 Table of Contents
- [📖 Table of Contents](#-table-of-contents)
- [📍 Overview](#-overview)
- [📦 Features](#-features)
- [📂 repository Structure](#-repository-structure)
- [⚙️ Modules](#modules)
- [🚀 Getting Started](#-getting-started)
    - [🔧 Installation](#-installation)
    - [🤖 Running Chills-App-Backend](#-running-Chills-App-Backend)
    - [🧪 Tests](#-tests)
- [🛣 Roadmap](#-roadmap)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [👏 Acknowledgments](#-acknowledgments)

---


## 📍 Overview

The Chills App Backend repository is a project that aims to provide a backend solution for the Chills App. It includes features such as product insertion and image management, as well as a pre-configured database setup. The app allows users to easily add new products to the Chills App and manage product images efficiently. The codebase consists of various files and directories that handle the backend logic and database setup. Overall, it provides a valuable contribution to the Chills App, enhancing its functionality and user experience.

---

## 📦 Features

Exception: 

---


## 📂 Repository Structure

```sh
└── Chills-App-Backend/
    ├── app/
    │   ├── .mvn/
    │   │   └── wrapper/
    │   ├── InsertProduct.py
    │   ├── images/
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── sql/
    │   │   └── chillisdb.sql
    │   └── src/
    │       ├── main/
    │       └── test/
    ├── docker-compose.yml
    └── dockerfile

```

---


## ⚙️ Modules

<details closed><summary>Root</summary>

| File                                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| ---                                                                                                | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| [dockerfile](https://github.com/CMoreno04/Chills-App-Backend/blob/main/dockerfile)                 | The code is a Dockerfile used to build a container image for the Chills-App-Backend application. It starts with an ARM-compatible base image with Maven and Java 17. It sets the working directory, copies the pom.xml file, fetches the dependencies, and then copies the source code into the image. Maven is used to package the application without running tests. The container is configured to expose port 8081 and run the built Spring Boot application as a.war file. |
| [docker-compose.yml](https://github.com/CMoreno04/Chills-App-Backend/blob/main/docker-compose.yml) | HTTPStatus Exception: 503                                                                                                                                                                                                                                                                                                                                                                                                                                                       |

</details>

<details closed><summary>App</summary>

| File                                                                                                                                                      | Summary                                                                                                                                                                                                                                                                                                                                                                                                                          |
| ---                                                                                                                                                       | ---                                                                                                                                                                                                                                                                                                                                                                                                                              |
| [mvnw.cmd](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/mvnw.cmd)                                                                        | HTTPStatus Exception: 503                                                                                                                                                                                                                                                                                                                                                                                                        |
| [mvnw](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/mvnw)                                                                                | HTTPStatus Exception: 429                                                                                                                                                                                                                                                                                                                                                                                                        |
| [InsertProduct.py](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/InsertProduct.py)                                                        | This code in the `InsertProduct.py` script inserts a list of products into a MySQL database table. It connects to the database using pymysql, reads the images associated with each product and loads them as binary blobs into the product objects. It then uses a context manager to ensure a clean connection and cursor, executes a bulk insert query to insert all the products into the database, and commits the changes. |
| [AppApplicationTests.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/test/java/com/chillsrestaurant/app/AppApplicationTests.java) | The code provided is a test class for the Chills-App-Backend application. It is written in Java and uses the Spring Boot framework. This test class, named AppApplicationTests, is responsible for testing the application's context loading functionality. It ensures that the application loads successfully without any errors.                                                                                               |
| [ServletInitializer.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/ServletInitializer.java)   | The code represents a Java Servlet Initializer class that configures the Spring Boot application. It extends the SpringBootServletInitializer class and overrides the configure() method. The configure() method takes a SpringApplicationBuilder object as a parameter and returns the same object. It is responsible for configuring the application sources for deployment.                                                   |
| [AppApplication.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/AppApplication.java)           | The code is a Java Spring Boot application that serves as the main entry point for the Chills Restaurant backend app. When executed, it starts the application by running the SpringApplication class from the com.chillsrestaurant.app package.                                                                                                                                                                                 |

</details>

<details closed><summary>Security</summary>

| File                                                                                                                                                   | Summary                                                                                                                                                                                                           |
| ---                                                                                                                                                    | ---                                                                                                                                                                                                               |
| [OpenApiConfig.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/OpenApiConfig.java) | The code is a Java configuration file that sets up OpenAPI documentation for the Chills Restaurant API. It creates an OpenAPI bean with information about the API, including the title, version, and description. |

</details>

<details closed><summary>Config</summary>

| File                                                                                                                                                                          | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| ---                                                                                                                                                                           | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| [SecurityConfiguration.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/config/SecurityConfiguration.java) | The code above is the Security Configuration for a Spring Boot application called Chills-App-Backend. It contains the necessary configurations for implementing security in the application. The code sets up CSRF (Cross-Site Request Forgery) protection, CORS (Cross-Origin Resource Sharing) configuration, authorization rules, session management, and JWT (JSON Web Token) authentication. It also defines a PasswordEncoder for encrypting passwords, an AuthenticationProvider for user authentication, and an AuthenticationManager for managing authentication processes. |

</details>

<details closed><summary>Response</summary>

| File                                                                                                                                                                                        | Summary                                                                                                                                                                                                                                                                                                                                                                            |
| ---                                                                                                                                                                                         | ---                                                                                                                                                                                                                                                                                                                                                                                |
| [RegisteredResponse.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/response/RegisteredResponse.java)               | The code is a Java class called RegisteredResponse located in the package com.chillsrestaurant.app.security.dao.response. It is used to create an object that represents a response when a user is registered. The class has a single field named username, and uses Lombok annotations for automatically generating getter and setter methods, constructors, and builder methods. |
| [JwtAuthenticationResponse.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/response/JwtAuthenticationResponse.java) | The code is a Java class that represents a response object for JWT authentication. It includes the token and role of the authenticated user. The class is designed using Lombok annotations for generating getters, setters, constructors, and builders.                                                                                                                           |

</details>

<details closed><summary>Request</summary>

| File                                                                                                                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| ---                                                                                                                                                                                | ---                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| [CustomerSigninRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/CustomerSigninRequest.java) | Exception:                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| [SigninRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/SigninRequest.java)                 | The code defines a Java class called SigninRequest, which is located in the package com.chillsrestaurant.app.security.dao.request. The class has a single attribute called password, and it is annotated with Lombok annotations for data, builder, no-args constructor, and all-args constructor. These annotations provide boilerplate code for generating getter and setter methods, builder methods, and constructors.                       |
| [EmployeeSignUpRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/EmployeeSignUpRequest.java) | The code is a Java class that defines the "EmployeeSignUpRequest" object used in the Chills-App-Backend system. It extends the "SignUpRequest" class and adds a "employeeId" property to it. It makes use of the Lombok library for generating boilerplate code.                                                                                                                                                                                 |
| [EmployeeSigninRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/EmployeeSigninRequest.java) | HTTPStatus Exception: 503                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [CustomerSignUpRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/CustomerSignUpRequest.java) | The code above is a Java class called CustomerSignUpRequest that extends another class called SignUpRequest. It is part of a backend application for a restaurant called Chills-App. This class is used to create customer signup requests and contains a field for the customer's username. It also includes annotations for data generation, comparison, and constructors.                                                                     |
| [SignUpRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/SignUpRequest.java)                 | The code represents a Java class called SignUpRequest that is used for handling requests related to user sign-up in a restaurant application. It contains fields for first name, last name, email, password, and role. The class uses the Lombok library to automatically generate getters, setters, constructors, and other common methods. This class is used to capture and store user sign-up information in the backend of the application. |

</details>

<details closed><summary>Filter</summary>

| File                                                                                                                                                                              | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| ---                                                                                                                                                                               | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| [JwtAuthenticationFilter.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/filter/JwtAuthenticationFilter.java) | The provided code is a Java filter class called `JwtAuthenticationFilter`. It is responsible for performing authentication using JSON Web Tokens (JWTs) in a Spring Boot application. When a request is made, the filter checks for the presence of the "Authorization" header and verifies that it starts with "Bearer ". If the header is found, the filter extracts the JWT and its associated user email. The filter then uses a JWT service to validate the token and obtain the user details. If the token is valid and there is no existing authentication context, the filter sets the user details in the security context for further request processing.Overall, the `JwtAuthenticationFilter` enhances security by authenticating requests using JWTs in a Spring Boot application. |

</details>

<details closed><summary>Repositories</summary>

| File                                                                                                                                                                 | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| ---                                                                                                                                                                  | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| [CustomerRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/CustomerRepository.java) | The code defines a Java interface called CustomerRepository that extends the JpaRepository interface. It provides methods for accessing and manipulating data related to the Customer entity in the Chills-App-Backend. The interface includes methods to find a customer by email and to find the email associated with a username using custom queries. This interface is used for data access and manipulation in the Chills-App-Backend application. |
| [EmployeeRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/EmployeeRepository.java) | The code represents the EmployeeRepository class, which is responsible for handling data access and queries related to the Employee entity in the Chills-App-Backend. It extends the JpaRepository interface, providing methods like findByEmail and findByEmployeeId to find employee information. Additionally, it includes a custom query using @Query annotation to retrieve an employee's email by their employeeId.                                |
| [UserRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/UserRepository.java)         | HTTPStatus Exception: 503                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [MenuItemRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/MenuItemRepository.java) | The code provided is a Java interface called MenuItemRepository. It is a repository interface that extends the JpaRepository interface from the Spring Data JPA framework. This interface is responsible for providing CRUD operations (Create, Read, Update, Delete) and other database operations for the MenuItem entity.                                                                                                                             |

</details>

<details closed><summary>Controllers</summary>

| File                                                                                                                                                                            | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| ---                                                                                                                                                                             | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| [AuthenticationController.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Controllers/AuthenticationController.java) | The code above is a part of the Chills-App-Backend project and specifically focuses on the Authentication functionality. It is a Java Spring controller that handles different signup and signin requests for both employees and customers. The controller receives HTTP requests and maps them to specific methods for handling the authentication process. These methods interact with the AuthenticationService to perform the necessary operations and return the appropriate response to the client. |
| [MenuItemController.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Controllers/MenuItemController.java)             | The code is a Java Spring Boot controller that handles requests related to menu items in a restaurant app. It retrieves a list of menu items from the menu item service and returns the response as a list of MenuItemDTO objects. The controller is mapped to the "/api/food" endpoint and provides a GET method ("/all") that returns all menu items from the database.                                                                                                                                 |

</details>

<details closed><summary>Services</summary>

| File                                                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| ---                                                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| [JwtService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/JwtService.java)                       | The code above defines a Java interface called JwtService, which contains three methods. The extractUserName method takes a token as input and returns the username extracted from the token. The generateToken method generates a token based on the given user details. The isTokenValid method checks if the given token is valid for the given user details. This interface is intended to be implemented by classes that provide JWT (JSON Web Token) authentication services.                             |
| [UserService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/UserService.java)                     | The code above defines an interface called UserService in the Services package of a Java Spring application. This interface extends the UserDetailsService interface, which is part of the Spring Security framework. The UserService interface declares a single method, userDetailsService(), that returns an instance of UserDetailsService. The purpose of this interface is to define a contract for a service that handles user details for authentication and authorization purposes in the application. |
| [MenuItemService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/MenuItemService.java)             | The code is a part of the Chills Restaurant backend application. It defines a service called MenuItemService, which is responsible for retrieving menu items from the database. The service uses the MenuItemRepository to fetch all menu items and then converts them into MenuItemDTO objects. Finally, it returns a list of MenuItemDTOs representing all the menu items in the database.                                                                                                                    |
| [AuthenticationService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/AuthenticationService.java) | This code defines an interface called AuthenticationService. It has two methods: signup() and signin(). The signup() method takes a SignUpRequest object as input and returns a JwtAuthenticationResponse object. The signin() method takes a SigninRequest object as input and also returns a JwtAuthenticationResponse object. These methods are used for user authentication and registration in the Chills-App-Backend.                                                                                     |

</details>

<details closed><summary>Impl</summary>

| File                                                                                                                                                                                | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| ---                                                                                                                                                                                 | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
| [JwtServiceImpl.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/Impl/JwtServiceImpl.java)                       | The code provided is a Java implementation of a JSON Web Token (JWT) service. It contains methods for extracting the username from a JWT, generating a new token for a given user, and validating the authenticity and expiration of a token. The service uses the `io.jsonwebtoken` library for JWT operations and requires a signing key provided as a property (`token.signing.key`).                                                                                                                                                                                                  |
| [UserServiceImpl.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/Impl/UserServiceImpl.java)                     | The code snippet is a part of the backend implementation for the Chills-App. It defines a UserServiceImpl class that implements the UserService interface. The class provides a userDetailsService method that returns a UserDetailsService object. This object is responsible for loading user details by their username. The method uses the UserRepository to find a user by their email address and throws an exception if the user is not found.                                                                                                                                     |
| [AuthenticationServiceImpl.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/Impl/AuthenticationServiceImpl.java) | The code is an implementation of the AuthenticationService interface. It provides functionalities for user authentication and authorization. It includes methods for user signup and signin. The signup method registers a user either as an Employee or a Customer, depending on the type of request. The signin method validates the user's credentials and generates a JSON Web Token (JWT) for authentication. It utilizes repositories to interact with the database, a password encoder for secure password storage, and an authentication manager for validating user credentials. |

</details>

<details closed><summary>Entities</summary>

| File                                                                                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| ---                                                                                                                                                | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| [Order.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Order.java)             | The provided code represents the Order entity class in the Chills-App-Backend project. It contains fields for the order ID, order time, order status, customer, employee, order items, and additional details like notes. The class utilizes JPA annotations for mapping the entity to the database and defines relationships with other entity classes such as Customer and Employee. It also includes annotations for handling cascading operations on the order items and Lombok annotations for generating the required methods.             |
| [OrderItem.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/OrderItem.java)     | The code represents the OrderItem entity of a restaurant app. It is a Java class annotated with JPA annotations. It has fields to store the id, order, menu item, quantity, and special instructions for an order item. The class is mapped to a database table named "order_items".                                                                                                                                                                                                                                                             |
| [Customer.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Customer.java)       | This code defines a Java class called "Customer" that extends another class called "User". The Customer class is marked as an entity using the Jakarta Persistence annotation, and it has a field for the customer's username. The class also includes constructors, getters, and setters using Lombok annotations for code generation.                                                                                                                                                                                                          |
| [OrderStatus.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/OrderStatus.java) | The code is an enumeration class called OrderStatus.java. It defines four constant values: PENDING, IN_PROGRESS, COMPLETED, and CANCELED. These values represent the different statuses that an order can have in the Chills-App-Backend.                                                                                                                                                                                                                                                                                                        |
| [User.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/User.java)               | This code represents the User entity class in the Chills-App-Backend. It is a Java class that implements the UserDetails interface. It contains attributes such as id, firstName, lastName, email, password, and role. It also includes methods for handling user authentication and authorization. The User class is mapped to a database table using annotations and follows a joined inheritance strategy. Overall, it provides the necessary functionality for managing user details and security within the Chills-App-Backend application. |
| [MenuItem.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/MenuItem.java)       | The code defines a Java class named MenuItem in the com.chillsrestaurant.app.Entities package. It represents a menu item in a restaurant and contains properties such as id, price, description, name, category, and imageBlob. The class is annotated with JPA annotations to map it to a database table. The imageBlob property is annotated with @Lob to indicate that it stores large binary data.                                                                                                                                           |
| [Role.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Role.java)               | The code represents an enum called "Role" within the "Entities" package of a Java application. It defines three possible roles: "CUSTOMER", "ADMIN", and "EMPLOYEE".                                                                                                                                                                                                                                                                                                                                                                             |
| [Employee.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Employee.java)       | This code defines an Employee class that represents an entity in a Chills Restaurant application. It inherits from a User class and includes additional fields such as employeeId. It also includes getter methods to retrieve the id and email of the employee. The class is annotated with various Lombok annotations for generating boilerplate code.                                                                                                                                                                                         |

</details>

<details closed><summary>Dto</summary>

| File                                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| ---                                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| [MenuItemDTO.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/dto/MenuItemDTO.java) | The code is defining a data transfer object (DTO) class called MenuItemDTO. It has properties for storing the ID, price, description, name, category, and image of a menu item. The class also includes a constructor that takes a MenuItem object and initializes the properties with its values. The image property is converted to a Base64-encoded string using the Base64 class. The DTO is used to transfer data between layers or components in the application.                                                                                                                                        |
| [OrderDTO.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/dto/OrderDTO.java)       | The code defines a Java DTO (Data Transfer Object) class called OrderDTO, which represents an order in a restaurant application. It has several properties like id, orderTime, status, notes, customer, employee, and a list of order items. The customer, employee, and order item properties are also defined as inner DTO classes. The DTO is used to transfer order-related data between different layers or components of the application, providing a standardized format for the data. Lombok annotations are used to automatically generate getters, setters, and a no-args constructor for the class. |

</details>

---

## 🚀 Getting Started

***Dependencies***

Please ensure you have the following dependencies installed on your system:

`- ℹ️ Dependency 1`

`- ℹ️ Dependency 2`

`- ℹ️ ...`

### 🔧 Installation

1. Clone the Chills-App-Backend repository:
```sh
git clone https://github.com/CMoreno04/Chills-App-Backend
```

2. Change to the project directory:
```sh
cd Chills-App-Backend
```

3. Install the dependencies:
```sh
mvn clean install
```

### 🤖 Running Chills-App-Backend

```sh
java -jar target/myapp.jar
```

### 🧪 Tests
```sh
mvn test
```

---


## 🛣 Project Roadmap

> - [X] `ℹ️  Task 1: Implement X`
> - [ ] `ℹ️  Task 2: Implement Y`
> - [ ] `ℹ️ ...`


---

## 🤝 Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Submit Pull Requests](https://github.com/CMoreno04/Chills-App-Backend/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/CMoreno04/Chills-App-Backend/discussions)**: Share your insights, provide feedback, or ask questions.
- **[Report Issues](https://github.com/CMoreno04/Chills-App-Backend/issues)**: Submit bugs found or log feature requests for CMORENO04.

#### *Contributing Guidelines*

<details closed>
<summary>Click to expand</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone <your-forked-repo-url>
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear and concise message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

## 📄 License


This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

## 👏 Acknowledgments

- List any resources, contributors, inspiration, etc. here.

[**Return**](#Top)

---

