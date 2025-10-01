# Stage 1: build dengan Maven
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy hasil build (jar) dari stage builder
COPY --from=builder /app/target/*.jar app.jar

# Expose port SOAP service (default Spring WS biasanya 8080)
EXPOSE 8080

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
