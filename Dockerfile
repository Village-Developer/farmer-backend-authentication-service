FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 9000

ARG JAR_FILE=target/farmer-0.0.1-SNAPSHOT.war

ADD ${JAR_FILE} farmer.war

ENTRYPOINT ["java","-jar","farmer.war"]