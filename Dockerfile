# Use a Java base image
FROM openjdk:17-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8080
# Run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]