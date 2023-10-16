FROM maven:3.6-jdk-8

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "target/manager-0.0.1-SNAPSHOT.jar"]
