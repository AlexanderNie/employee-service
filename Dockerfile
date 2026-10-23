# 1. Start with a Java 25 runtime
FROM eclipse-temurin:25-jre

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy the packaged Spring Boot JAR into the image
COPY target/employee-service-0.0.1-SNAPSHOT.jar app.jar

# 4. Document the port used by Spring Boot
EXPOSE 8080

# 5. Start the application when the container runs
ENTRYPOINT ["java", "-jar", "app.jar"]