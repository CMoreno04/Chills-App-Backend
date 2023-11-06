<div align="center">
<h1 align="center">
<img src="https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/images/chills_cold.jpg" width="500"  />
<br>CHILLS-APP-BACKEND</h1>
<h3>◦ Chills-App-Backend: Unleash endless possibilities!</h3>
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
- [📂 repository Structure](#-repository-structure)
- [⚙️ Modules](#modules)
- [🚀 Getting Started](#-getting-started)
    - [🔧 Installation](#-installation)
    - [🤖 Running Chills-App-Backend](#-running-Chills-App-Backend)
    - [🧪 Tests](#-tests)

---


## 📍 Overview

The Chills-App-Backend repository is a project that provides a backend solution for the Chills App. It includes functionalities such as inserting products, managing images, and handling database operations. With this codebase, developers can easily build and integrate the backend logic required for the Chills App, enhancing its functionality and user experience.

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

| File                                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| ---                                                                                                | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| [dockerfile](https://github.com/CMoreno04/Chills-App-Backend/blob/main/dockerfile)                 | Creates a Docker image for the Chills-App-Backend project. It uses an ARM-compatible base image with Maven and Java 17. The code sets the working directory, copies the pom.xml file to fetch dependencies, and then copies the src directory containing the source code. Maven is used to package the application without running tests. The code also exposes port 8081 and runs the built Spring Boot application using the packaged WAR file.                                                                                 |
| [docker-compose.yml](https://github.com/CMoreno04/Chills-App-Backend/blob/main/docker-compose.yml) | Defines a Docker Compose configuration file. It sets up multiple services, including the backend for a Chills Restaurant app, a MariaDB database, a React app, and an Nginx proxy. The Chills Restaurant backend service is configured with environment variables for the server, database, logging, and security settings. The MariaDB service is configured with a root password and a database. The React app is configured with an API URL. The Nginx proxy is configured with SSL certificates and a custom nginx.conf file. |

</details>

<details closed><summary>App</summary>

| File                                                                                                                                                      | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| ---                                                                                                                                                       | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| [mvnw.cmd](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/mvnw.cmd)                                                                        | A Windows batch script that starts the Apache Maven Wrapper, a tool that automatically downloads and configures the necessary Maven version for a project. It checks the presence and validity of the Java path, sets up the project base directory, downloads the Maven Wrapper if necessary, verifies its SHA-256 sum, and then runs Maven with the provided command line arguments. It also includes the option to execute pre and post scripts before and after the Maven Wrapper execution.                                                                                                                   |
| [mvnw](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/mvnw)                                                                                | A shell script that starts the Apache Maven Wrapper, which is a way to ensure that a specific version of Maven is used for a project, regardless of the version installed on the system. The script finds the project base directory, downloads the Maven wrapper if necessary, sets the Java and Maven environment variables, and then invokes the Maven wrapper to execute Maven commands with the specified arguments.                                                                                                                                                                                                |
| [InsertProduct.py](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/InsertProduct.py)                                                        | An implementation of a script called "InsertProduct.py" in the "Chills-App-Backend/app" directory. It utilizes the pymysql library to connect to a MySQL database called "chillisdb". The script inserts a list of products into the "MenuItem" table in the database. Each product has attributes such as name, price, description, imageUrl, and category. The script reads the image files specified in the "imageUrl" attribute and converts them into image blobs to be stored in the database. It then uses a bulk insert method to efficiently insert all the products into the database and commits the changes. |
| [AppApplicationTests.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/test/java/com/chillsrestaurant/app/AppApplicationTests.java) | A test class called "AppApplicationTests" located in the "app/src/test/java/com/chillsrestaurant/app" path. It uses the Spring Boot framework to test the application's context loading functionality. It is annotated with "@SpringBootTest" to indicate that it is a Spring Boot test. The "contextLoads" method is empty, indicating that it is a basic test to ensure that the application's context can be successfully loaded.                                                                                                                                                                                    |
| [ServletInitializer.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/ServletInitializer.java)   | A Java class that extends SpringBootServletInitializer and overrides the configure() method. This class is responsible for configuring the Spring Boot application for deployment in a servlet container. It sets the main application class, AppApplication, as the source for the application.                                                                                                                                                                                                                                                                                                                         |
| [AppApplication.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/AppApplication.java)           | Basic Spring Boot application starter class in Java. This is usually the entry point of a Spring Boot application, containing the `main` method that is required to run the application. The `@SpringBootApplication` annotation is a convenience annotation that adds:

- `@Configuration`: Tags the class as a source of bean definitions for the application context.
- `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
- `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the `com.chillsrestaurant.app` package, allowing it to find controllers, services, etc.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

</details>

<details closed><summary>Security</summary>

| File                                                                                                                                                   | Summary                                                                                                                                                                             |
| ---                                                                                                                                                    | ---                                                                                                                                                                                 |
| [OpenApiConfig.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/OpenApiConfig.java) |OpenApiConfig.java configures and provides an instance of OpenAPI for the Chills Restaurant API. It sets the title, version, and description for the API documentation. |

</details>

<details closed><summary>Config</summary>

| File                                                                                                                                                                          | Summary                                                                                                                                                                                                                                                                                                                                                           |
| ---                                                                                                                                                                           | ---                                                                                                                                                                                                                                                                                                                                                               |
| [SecurityConfiguration.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/config/SecurityConfiguration.java) | Security Configuration for a Spring Boot application. It sets up various security features such as CSRF protection, CORS configuration, authorization rules, session management, and authentication providers. It also implements a JWT filter for authentication. Additionally, it defines a password encoder and an authentication manager. |

</details>

<details closed><summary>Response</summary>

| File                                                                                                                                                                                        | Summary                                                                                                                                                                                                                                                                                |
| ---                                                                                                                                                                                         | ---                                                                                                                                                                                                                                                                                    |
| [RegisteredResponse.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/response/RegisteredResponse.java)               | Java class that defines a response object for a security-related DAO operation in a Chills Restaurant application. The class has four annotations: @Data, @Builder, @NoArgsConstructor, and @AllArgsConstructor. It has a single field called "username" of type String. |
| [JwtAuthenticationResponse.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/response/JwtAuthenticationResponse.java) |  Class named "JwtAuthenticationResponse" that is meant to be a response object for JWT authentication. It has two properties: "token" and "role". The class is annotated with Lombok annotations for generating getters, setters, constructors, and builder methods. |

</details>

<details closed><summary>Request</summary>

| File                                                                                                                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ---                                                                                                                                                                                | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [CustomerSigninRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/CustomerSigninRequest.java) |  Java class called "CustomerSigninRequest" which extends another class called "SigninRequest". It represents a request for customer sign-in and includes a field for the username. The class uses Lombok annotations to automatically generate getters, setters, and constructor methods for the field.|
| [EmployeeSignUpRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/EmployeeSignUpRequest.java) |  Java class named "EmployeeSignUpRequest" that extends another class called "SignUpRequest". It includes a data field called "employeeId" and utilizes Lombok annotations for generating getters, setters, equals, hashCode, and a default constructor. This class is used for representing a request object for employee sign-up functionality in a security-related DAO (Data Access Object) package of the Chills-App-Backend application. |
| [EmployeeSigninRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/EmployeeSigninRequest.java) |  Java class named "EmployeeSigninRequest" which extends another class named "SigninRequest". It has a private field named "employeeId" and uses the Lombok library for generating getter, setter, constructor, and equals/hashCode methods. This class is located in a specific package within the "app/src/main/java/com/chillsrestaurant/app/security/dao/request" directory of a project named "Chills-App-Backend". |   
| [SignUpRequest.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/dao/request/SignUpRequest.java)                 | Java class that defines a data transfer object (DTO) for a sign-up request. It contains properties for a user's first name, last name, email, password, and role. The class is annotated with Lombok annotations to automatically generate getters, setters, constructors, and other boilerplate code. This DTO is likely used for handling user registration in an application's security module.|

</details>

<details closed><summary>Filter</summary>

| File                                                                                                                                                                              | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| ---                                                                                                                                                                               | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [JwtAuthenticationFilter.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/security/filter/JwtAuthenticationFilter.java) | Java class that represents a JWT (JSON Web Token) authentication filter. It is used to authenticate and authorize requests in a web application. The filter checks for a JWT in the request's "Authorization" header, extracts the user email from the token, and validates the token. If the token is valid, the filter sets the user's authentication details in the security context. It then allows the request to proceed to the next step in the filter chain. |

</details>

<details closed><summary>Repositories</summary>

| File                                                                                                                                                                 | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| ---                                                                                                                                                                  | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| [CustomerRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/CustomerRepository.java) | Java interface called CustomerRepository that extends the JpaRepository interface. It provides methods for accessing and manipulating Customer entities in a database. It includes methods for finding a customer by email, finding customer email by username, and performing other common CRUD operations on the Customer entity. The code also includes annotations for mapping the repository to the database and specifying SQL queries using the @Query annotation. |
| [EmployeeRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/EmployeeRepository.java) | Java interface called EmployeeRepository that extends the JpaRepository interface. It provides methods for accessing and manipulating Employee entities in a database. It includes methods for finding a customer by email, finding customer email by username, and performing other common CRUD operations on the Employee entity. The code also includes annotations for mapping the repository to the database and specifying SQL queries using the @Query annotation.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| [UserRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/UserRepository.java)         | Repository interface in a Java project that uses Spring Data JPA. It extends the JpaRepository interface, which provides basic CRUD operations for the User entity. The interface declares a custom method "findByEmail", which allows finding a User entity by its email address. The UserRepository interface is also annotated with the @Repository annotation, indicating that it is a Spring-managed repository component.                                       |
| [MenuItemRepository.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Repositories/MenuItemRepository.java) | Repository interface named MenuItemRepository. It extends the JpaRepository interface, which is provided by the Spring Data JPA framework. This interface allows the application to perform CRUD operations (create, read, update, delete) on MenuItem objects stored in a database using Java Persistence API (JPA).                                                                                                                                                     |

</details>

<details closed><summary>Controllers</summary>

| File                                                                                                                                                                            | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| ---                                                                                                                                                                             | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          |
| [AuthenticationController.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Controllers/AuthenticationController.java) | AuthenticationController class, which is responsible for handling various authentication endpoints. It includes methods for employee and customer sign up, as well as sign in. Each method has an endpoint mapping, request body parameter, and an operation summary. The methods return appropriate ResponseEntity objects based on the request and authentication service responses. Overall, this code provides registration and sign-in services for both employees and customers. |
| [MenuItemController.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Controllers/MenuItemController.java)             | Java class called MenuItemController, which is a REST controller responsible for handling HTTP requests related to menu items in a restaurant app. It has a GET method that returns a list of menu items stored in a database. The controller uses MenuItemService, a service class, to retrieve the menu items from the database and return them as a response.                                                                                                                          |

</details>

<details closed><summary>Services</summary>

| File                                                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ---                                                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| [JwtService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/JwtService.java)                       | Interface called JwtService that contains three methods. The extractUserName method takes a token and returns the username extracted from the token. The generateToken method takes a UserDetails object and generates a token based on the user details. The isTokenValid method takes a token and a UserDetails object and checks if the token is valid for the given user details.                         |
| [UserService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/UserService.java)                     | Interface called UserService that extends the UserDetailsService interface from the Spring Security framework. The UserService interface has one method, userDetailsService(), which returns an instance of the UserDetailsService interface.                                                                                                                                                                 |
| [MenuItemService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/MenuItemService.java)             | Service class called `MenuItemService` in the `com.chillsrestaurant.app.Services` package. This class contains a method `getAllProducts` which retrieves all menu items from the database using the `MenuItemRepository`. It returns a list of `MenuItemDTO` objects, which are created from the retrieved menu items. The `MenuItemService` is annotated with `@Service` to indicate that it is a Spring service. |
| [AuthenticationService.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/AuthenticationService.java) | Interface for an authentication service in a restaurant application. It includes methods for signing up and signing in users, taking in request objects and returning a response object with a JWT authentication token.                                                                                                                                                                                               |

</details>

<details closed><summary>Impl</summary>

| File                                                                                                                                                                                | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| ---                                                                                                                                                                                 | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
| [JwtServiceImpl.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/Impl/JwtServiceImpl.java)                       | Java class that implements the JwtService interface for handling JSON Web Tokens (JWT) in a Spring Boot application. It provides methods for extracting the username from a token, generating a token based on user details, and validating the token's authenticity and expiration. The class uses the io.jsonwebtoken library for parsing and generating JWTs, and it also includes methods for extracting specific claims from a token and retrieving the token's expiration date. The signing key for JWTs is injected from an external configuration file.                                                        |
| [UserServiceImpl.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/Impl/UserServiceImpl.java)                     | Defines a service class `UserServiceImpl` in a Spring Boot application that implements a custom `UserService` interface. This service is responsible for integrating with Spring Security by providing a `UserDetailsService` that loads user-specific data.
The `UserServiceImpl` class is annotated with `@Service`, indicating that it's a Spring managed service bean. It implements the `UserService` interface and defines the `userDetailsService` method, which returns an anonymous inner class that implements `UserDetailsService`. This inner class provides the `loadUserByUsername` method, crucial for user authentication in Spring Security.

Here's a breakdown of the code and its components:

- `@Service`: This annotation marks the class as a Spring service stereotype. It's a specialization of `@Component`, and it allows the Spring framework to detect this class for dependency injection.

- `@Autowired`: This is used to auto-wire the `UserRepository` bean, which presumably is an interface extending `Spring Data JPA`'s `JpaRepository`. It injects an instance of `UserRepository` into the `UserServiceImpl` service.

- `userDetailsService` method: This method overrides a method from the `UserService` interface. It provides an implementation of the `UserDetailsService` interface.

- `loadUserByUsername`: This is the only method in the `UserDetailsService` interface. It's used by Spring Security to load user details and perform authentication. The `findByEmail` method suggests that in this application, the email is used as the username for authentication purposes. If a user with the given email (username) isn't found, a `UsernameNotFoundException` is thrown.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| [AuthenticationServiceImpl.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Services/Impl/AuthenticationServiceImpl.java) | Java implementation of the Authentication Service. It provides functionalities for user signup and signin. The code includes methods to handle signup and signin requests for both employees and customers. The signup method takes a SignUpRequest and uses it to create a new user. The user's information is then stored in either the Employee or Customer repository. The signin method takes a SigninRequest and authenticates the user based on their email and password. If authentication is successful, a JWT (JSON Web Token) is generated using the JwtService and returned as a JwtAuthenticationResponse. |

</details>

<details closed><summary>Entities</summary>

| File                                                                                                                                               | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| ---                                                                                                                                                | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| [Order.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Order.java)             | Java class "Order" in the Chills-App-Backend project. It defines the entity class for an order, including attributes such as id, orderTime, status, customer, employee, orderItems, and notes. It utilizes JPA annotations for database mapping and Lombok annotations for generating default constructors, getters, and setters.                                                                                                                                                                          |
| [OrderItem.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/OrderItem.java)     | OrderItem entity class for the Chills-App-Backend. It is used to represent an individual item in an order at a restaurant. The OrderItem has properties such as id, order (referring to the order it belongs to), menuItem (referring to the menu item being ordered), quantity, and specialInstructions. The class uses JPA annotations for mapping to the database and Lombok annotations for generating getters, setters, and constructors.                                                                   |
| [Customer.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Customer.java)       |Customer class within the Chills-App-Backend project. It is a Java class that represents a customer entity in a restaurant application. The Customer class extends the User class and is annotated with the jakarta.persistence.Entity annotation, indicating that it is a persistent entity in a database. It includes a username field and overrides the getUsername() method from the User class to return the value of the username field. The class also uses lombok annotations for generating boilerplate code. |
| [OrderStatus.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/OrderStatus.java) | Enumeration class called OrderStatus, which represents the different statuses that an order can have in a restaurant application. The possible order statuses are PENDING, IN_PROGRESS, COMPLETED, and CANCELED. This class is located in the Entities package of the project under the path `app/src/main/java/com/chillsrestaurant/app/Entities/OrderStatus.java`.                                                                                                                                                |
| [User.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/User.java)               | User entity for a Chills Restaurant application backend. It defines the properties and behaviors of a User object, including attributes like id, firstName, lastName, email, password, and role. It implements the UserDetails interface and provides methods for authentication and authorization. The User class also defines the necessary annotations for persistence and inheritance.                                                                                                                          |
| [MenuItem.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/MenuItem.java)       | MenuItem entity in the Chills-App-Backend project. It defines the structure and properties of a menu item, including the ID, price, description, name, category, and image. The image is stored as a byte array in a column defined as a LONGBLOB type.                                                                                                                                                                                                                                                             |
| [Role.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Role.java)               | n enumeration called "Role" within the "Entities" package. It includes three predefined values: CUSTOMER, ADMIN, and EMPLOYEE. This enumeration is used to represent different roles within a restaurant application.                                                                                                                                                                                                                                                                                                     |
| [Employee.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/Employee.java)       | Java class named "Employee" that represents an entity in a Chills Restaurant application. It extends the "User" class and adds an additional field called "employeeId". The class overrides two methods from the superclass to return the ID and email of the employee. The class is annotated with various Lombok annotations for generating getter and setter methods, constructors, and builder methods. It is also annotated as an entity for persistence purposes.                                                       |

</details>

<details closed><summary>Dto</summary>

| File                                                                                                                                                   | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                             |
| ---                                                                                                                                                    | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| [MenuItemDTO.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/dto/MenuItemDTO.java) | Data Transfer Object (DTO) class named MenuItemDTO.java. It represents a menu item entity and provides a way to transfer data between layers of the application. The class has fields for id, price, description, name, category, and image. It also has a constructor that takes a MenuItem object and sets the corresponding field values. The image field is encoded using Base64 encoding before setting it in the DTO object.                                    |
| [OrderDTO.java](https://github.com/CMoreno04/Chills-App-Backend/blob/main/app/src/main/java/com/chillsrestaurant/app/Entities/dto/OrderDTO.java)       | Java class that defines a Data Transfer Object (DTO) called OrderDTO. It represents an order entity and contains various properties such as order ID, order time, status, notes, and customer and employee details. It also includes inner DTO classes for customer, employee, order item, and menu item, each with their respective properties. The class utilizes Lombok annotations to automatically generate no-args constructors, getters, and setters. |

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
