FROM openjdk:17-jdk-alpine3.14
VOLUME /tmp
EXPOSE 8080

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Crear un grupo y un usuario para Spring
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

ENTRYPOINT ["java", "-jar", "/app.jar"]