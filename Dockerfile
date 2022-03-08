FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} banking.jar
ENTRYPOINT ["java","-jar","/banking.jar"]