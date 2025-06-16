# --- Build Stage ---
    FROM maven:3.9.6-eclipse-temurin-17 as builder

    WORKDIR /app
    COPY . .
    
    # Build the Spring Boot app (this creates the JAR)
    RUN mvn clean package -DskipTests
    
    # --- Run Stage ---
    FROM eclipse-temurin:17-jdk
    
    WORKDIR /app
    
    # Copy the built JAR from the previous stage
    COPY --from=builder /app/target/*.jar app.jar
    
    # Tell Spring Boot to use dynamic Render port
    ENV PORT=8080
    EXPOSE 8080