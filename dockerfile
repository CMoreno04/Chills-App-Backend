# Use an ARM-compatible base image with Maven and Java 17.
FROM arm32v7/maven:3.9.5-eclipse-temurin-17-focal

# Set the working directory in the container.
WORKDIR /app

# First, copy the pom.xml and fetch the dependencies.
# This is a separate step so that Docker can cache the Maven dependencies and not re-fetch them unless the pom.xml changes.
COPY app/pom.xml .
RUN mvn dependency:go-offline

# Copy the src directory (containing the source code) into the image.
COPY app/src ./src

# Use Maven to package the application without running tests for speed (you can remove the -DskipTests if needed).
RUN mvn clean package -DskipTests -P docker

# Expose the port that the app runs on.
EXPOSE 8082

# Run the built Spring Boot application.
CMD ["java", "-jar", "target/app-0.0.1-SNAPSHOT.war"]
