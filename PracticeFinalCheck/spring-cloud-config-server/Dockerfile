FROM openjdk:8u131-jdk-alpine
MAINTAINER "Satyam Kumar"
EXPOSE 8888
COPY ./target/spring-cloud-config-server-0.0.1-SNAPSHOT.jar ConfigServer.jar
CMD ["java","-jar","ConfigServer.jar"]