# Use the official maven/Java 17 image to create a build artifact.
FROM arm64v8/maven:3.8.4-openjdk-17-slim AS build

# Set the current working directory inside the image
WORKDIR /app

# Copy the pom.xml file first to leverage Docker cache
COPY pom.xml .

# Download the dependencies. This is a Docker trick 
# to keep the cached maven dependencies if the pom.xml doesn't change.
RUN mvn dependency:go-offline

# Copy the project source
COPY src ./src

# Package the application and clear maven cache to reduce image size.
RUN mvn clean package -DskipTests && \
    rm -rf target/classes && \
    rm -rf /root/.m2

FROM arm64v8/maven:3.9.5-eclipse-temurin-17

# Copy the WAR from the build stage
COPY --from=build /app/target/app-0.0.1-SNAPSHOT.war app.war

# Set the command to run your application using Spring Boot's embedded Tomcat.
CMD ["java", "-jar", "/app.war"]
