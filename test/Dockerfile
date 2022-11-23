FROM openjdk:15-jdk-alpine AS build
WORKDIR /app
COPY ../ .
RUN chmod +x ./gradlew
RUN ./gradlew :test:bootJar

FROM openjdk:15-jdk-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /app/test/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
