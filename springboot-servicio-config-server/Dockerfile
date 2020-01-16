FROM openjdk:8-jdk-alpine
EXPOSE 8888
VOLUME /tmp
COPY ./target/springboot-servicio-config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]