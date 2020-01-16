FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./target/springboot-servicio-productos-0.0.1-SNAPSHOT.jar servicio-productos.jar
ENTRYPOINT ["java","-jar","/servicio-productos.jar"]