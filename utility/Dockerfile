FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.11_9-slim as build
COPY target/utility-0.0.1-SNAPSHOT.jar utility-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "-Dserver.port=8002","/utility-0.0.1-SNAPSHOT.jar"]