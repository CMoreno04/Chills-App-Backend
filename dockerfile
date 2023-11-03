# Use an ARM-compatible base image with Maven and Java 17.
FROM arm32v7/tomcat:10.1.15-jdk17-temurin-jammy

# Delete the default web applications from Tomcat (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Add your WAR file to the Tomcat webapps directory
ADD app/target/app-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Optionally set the JAVA_OPTS environment variable if you need to pass additional options to the JVM
# ENV JAVA_OPTS="-Dsome.property=value"

# Expose the port your app runs on
EXPOSE 8081

# Start Tomcat server
CMD ["catalina.sh", "run"]
