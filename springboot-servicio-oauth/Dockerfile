FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9100
COPY ./target/springboot-servicio-oauth-0.0.1-SNAPSHOT.jar servicio-oauth.jar
ENTRYPOINT ["java","-jar","/servicio-oauth.jar"]