FROM openjdk:8-jre-alpine

MAINTAINER Nawel

WORKDIR /applications

COPY ms-cours1-0.0.1-SNAPSHOT.jar /applications/app.jar

ENTRYPOINT ["java", "-jar", "/applications/app.jar"]