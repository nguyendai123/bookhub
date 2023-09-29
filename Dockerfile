# Use a base image with JDK and Maven pre-installed for building the Spring Boot application

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar


# Install MariaDB client
RUN apt-get update && apt-get install -y mariadb-client

# Set environment variables for MariaDB connection
ENV DB_HOST localhost
ENV DB_PORT 3306
ENV DB_NAME db_bookhub
ENV DB_USER root
ENV DB_PASSWORD 1232001

# Expose the default Spring Boot port
EXPOSE 8080

# Set the command to run the Spring Boot application
ENTRYPOINT ["java","-jar","/app.jar"]