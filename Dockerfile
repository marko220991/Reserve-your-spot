# Use a Java base image
FROM openjdk:17-alpine
COPY build/libs/reservations-0.0.1-SNAPSHOT.jar reservations-0.0.1-SNAPSHOT.jar
EXPOSE 8080
# Run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "/reservations-0.0.1-SNAPSHOT.jar"]