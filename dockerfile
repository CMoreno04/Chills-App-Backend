# Use the official maven/Java 17 image to create a build artifact.
# Note: Ensure the maven image supports ARM, else you might need to manually create one.
FROM arm64v8/maven:3.8.4-openjdk-17-slim AS build

# Set the current working directory inside the image
WORKDIR /app

# Copy the pom.xml file to download dependencies
COPY pom.xml ./app

# Download the dependencies before we build the app, this is a Docker trick 
# in order to keep the cached maven dependencies if they don't change
RUN mvn dependency:go-offline

# Copy the project source
COPY src app/src/

# Package the application
RUN mvn clean package -DskipTests

# Use OpenJDK 17 for ARM to run the WAR
FROM arm64v8/openjdk:17-slim

# Copy the WAR from the build stage
COPY --from=build /app/target/app-0.0.1-SNAPSHOT.war app.war

# Set the command to run your application using Spring Boot's embedded Tomcat.
CMD ["java", "-jar", "/app.war"]
