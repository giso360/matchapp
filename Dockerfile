FROM openjdk:11.0.4
COPY target/matchodds-0.0.1-SNAPSHOT.jar matchodds-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/matchodds-0.0.1-SNAPSHOT.jar"]