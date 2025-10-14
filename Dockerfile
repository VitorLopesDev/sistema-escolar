# Etapa 1: Build com Maven
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom e o src
COPY pom.xml .
COPY src ./src

# Builda o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com JDK
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta do Spring Boot
EXPOSE 8080

# Comando para iniciar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
