# base image
FROM amazoncorretto:21-alpine-jdk

# create a work dir.
WORKDIR /app

# copy a jvm app.
COPY build/libs/*.jar app.jar

# startup a jvm app.
ENTRYPOINT ["java", "-jar", "app.jar"]
