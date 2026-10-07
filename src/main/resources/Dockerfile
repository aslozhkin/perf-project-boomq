FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/RestService-1.0-SNAPSHOT.jar app.jar

EXPOSE 8087

ENTRYPOINT ["java", "-jar", "app.jar"]