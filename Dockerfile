FROM openjdk:latest
ADD target/interview-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","app.war"]
EXPOSE 8080


