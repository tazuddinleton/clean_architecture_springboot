# Use the official OpenJDK 17 as the base image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY build/libs/movie_rental-0.0.1-SNAPSHOT.jar /app/movie_rental-0.0.1-SNAPSHOT.jar

# Expose the port on which the Spring Boot application runs
EXPOSE 8080

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "movie_rental-0.0.1-SNAPSHOT.jar"]