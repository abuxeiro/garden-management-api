FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/garden-management-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]