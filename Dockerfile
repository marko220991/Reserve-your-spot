# Use a Java base image
FROM openjdk:17-alpine
VOLUME /tmp
ARG DEPENDENCY=build/libs/reservations-0.0.2-SNAPSHOT.jar
RUN echo ${DEPENDENCY}
COPY ${DEPENDENCY} /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]