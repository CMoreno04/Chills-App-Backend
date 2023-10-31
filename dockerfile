# Use the official maven/Java 17 image to create a build artifact.
FROM arm64v8/maven:3.9.5-eclipse-temurin-17 AS build

WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source and package the application
COPY src src
RUN mvn clean package -DskipTests && \
    rm -rf target/classes && \
    rm -rf /root/.m2

# Use a JRE for running the application. Ensure the image exists and is compatible with ARM64 architecture.
FROM arm64v8/maven:3.9.5-eclipse-temurin-17

WORKDIR /app

# Copy the WAR from the build stage and set the command to run your application.
COPY --from=build /app/target/app-0.0.1-SNAPSHOT.war app.war
CMD ["java", "-jar", "app.war"]
