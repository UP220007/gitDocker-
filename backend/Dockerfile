FROM openjdk:17-alpine
#VOLUME /tmp
EXPOSE 8080

#ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Instalar mysql-client
RUN apk update && apk add mysql-client

# Agregar el script wait-for-it
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Crear y usar un usuario no root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ENTRYPOINT ["/wait-for-it.sh", "db:3306", "--", "java", "-jar", "/app.jar"]
