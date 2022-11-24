FROM gradle:7.1.1-jdk16-hotspot AS build
WORKDIR /app
COPY ../ .
RUN chmod +x ./gradlew
RUN gradle :common:bootJar

FROM openjdk:15-jdk-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /app/common/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
