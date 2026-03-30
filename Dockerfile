#FROM openjdk:27-ea-oracle
#ADD target/springboot-docker.jar springboot-docker.jar
#ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/springboot-docker.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]