FROM amazoncorretto:21-alpine-jdk AS builder
COPY ./src/demo /app
WORKDIR /app
RUN ./gradlew build && \
    cp ./build/libs/*SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
