# Use a base image with JDK and Maven pre-installed for building the Spring Boot application
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests


# Use a base image for the final application runtime
FROM openjdk:17.0.1-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file from the builder stage
COPY --from=builder /app/target/bookhup-0.0.1-SNAPSHOT.jar app.jar

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
CMD ["java", "-jar", "app.jar"]