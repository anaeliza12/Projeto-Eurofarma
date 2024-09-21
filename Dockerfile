FROM openjdk:17-jdk-alpine

WORKDIR /usr/src/app

COPY ./target/euforma-0.0.1-SNAPSHOT.jar .

EXPOSE 3000

CMD [ "java", "-jar", "euforma-0.0.1-SNAPSHOT.jar" ]