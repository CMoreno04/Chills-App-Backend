# Use the official OpenJDK 17 image as a parent image
FROM arm32v7/eclipse-temurin:17-jdk-focal

# Set the working directory in the Docker container
WORKDIR /app

# Copy the WAR file into the container at /app
COPY app/target/app-0.0.1-SNAPSHOT.war /app/app.war

# Specify the port the container should expose
EXPOSE 8081

# Use the "java" command to run the application
ENTRYPOINT ["java", "-jar", "app.war"]