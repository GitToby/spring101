FROM maven:3.8.1-openjdk-15 as build
WORKDIR "/app"
COPY --chown=777 src src
COPY --chown=777 pom.xml pom.xml
RUN ["mvn", "package"]

FROM openjdk:15-alpine as runtime
WORKDIR /example
COPY --chown=777 --from=build /app/target/*.jar app.jar
EXPOSE 12345 12345
ENTRYPOINT ["java", "-jar", "app.jar"]