# Use a multi-stage build to optimize size and separation of concerns
FROM arm64v8/maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY /app/pom.xml .
RUN mvn dependency:go-offline
COPY /app/src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-focal


COPY --from=builder /app/target/app-0.0.1-SNAPSHOT.war /app.war
CMD ["java", "-jar", "/app.war"]
