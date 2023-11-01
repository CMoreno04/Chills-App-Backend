# Use an ARM-compatible base image with Java 17 (e.g., adoptopenjdk or another provider that supports ARM).
FROM arm32v7/maven:3.9.5-eclipse-temurin-17-focal

# Set the working directory in the container
WORKDIR /app

RUN ls 

# Copy the pom.xml and src directory (containing the source code) into the image
COPY pom.xml .
COPY src ./src

# Use Maven to build the project inside the Docker image
RUN apt-get update && \
    apt-get install -y maven && \
    mvn clean package

# Expose the default port for Spring Boot web applications
EXPOSE 8082

# Run the built Spring Boot application
CMD ["java", "-jar", "target/your-spring-boot-app-name.jar"]

