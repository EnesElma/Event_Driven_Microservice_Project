FROM gradle:jdk11 AS builder
WORKDIR /app
COPY src ./src
COPY build.gradle .
RUN gradle assemble

FROM openjdk:11-jre-slim-buster
COPY --from=builder /app/build/libs/*.jar /app/my_app.jar
CMD java -jar /app/my_app.jar
