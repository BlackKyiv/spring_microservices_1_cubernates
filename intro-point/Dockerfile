FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.11_9-slim as build

COPY target/intro-point-0.0.1-SNAPSHOT.jar intro-point-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/intro-point-0.0.1-SNAPSHOT.jar"]