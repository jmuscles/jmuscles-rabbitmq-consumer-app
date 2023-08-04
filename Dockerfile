# Use a base image with Java installed
FROM openjdk:8-jdk-alpine

MAINTAINER javamuscles

# Copy the application JAR into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} jmuscles-rabbitmq-consumer-app-j8sb2713.jar

# Set the ENTRYPOINT with CMD to pass JAVA_OPTS to the Java application
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar jmuscles-rabbitmq-consumer-app-j8sb2713.jar" ]