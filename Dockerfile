FROM openjdk:11-jre-slim

WORKDIR /user-dashboard

COPY target/app.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
