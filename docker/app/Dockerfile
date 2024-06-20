FROM amazoncorretto:21-alpine-jdk AS builder
COPY ./src/demo /app
RUN cd /app && ./gradlew build

FROM amazoncorretto:21-alpine-jdk
COPY --from=builder /app/build/libs/*SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
