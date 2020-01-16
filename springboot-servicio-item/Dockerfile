FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8002
COPY ./target/springboot-servicio-item-0.0.1-SNAPSHOT.jar servicio-item.jar
ENTRYPOINT ["java","-jar","/servicio-item.jar"]