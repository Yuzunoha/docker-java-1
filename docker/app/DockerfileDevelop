# base image
FROM amazoncorretto:21-alpine-jdk
WORKDIR /app
RUN ./gradlew build
ENTRYPOINT ["java", "-jar", "app.jar"]
