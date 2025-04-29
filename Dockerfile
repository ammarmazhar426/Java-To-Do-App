FROM openjdk:17-jdk-slim

COPY target/todo-app.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]