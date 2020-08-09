FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11.0.8-jre-slim
COPY --from=build /home/app/target/*.jar portfolio-api.jar
ENTRYPOINT ["java","-jar","/portfolio-api.jar"]