# Use a base image with Java installed
FROM openjdk:8-jdk-alpine

MAINTAINER javamuscles

# Copy the application JAR into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} jmuscles-rabbitmq-consumer-app-j8sb2713-1.0.jar

#RUN curl -L https://github.com/aws-observability/aws-otel-java-instrumentation/releases/download/v1.28.1/aws-opentelemetry-agent.jar --output opentelemetry-javaagent.jar
#RUN curl -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar --output opentelemetry-javaagent.jar
# Set the ENTRYPOINT with CMD to pass JAVA_OPTS to the Java application
COPY aws-opentelemetry-agent.jar opentelemetry-javaagent.jar
ENTRYPOINT [ "sh", "-c", "java -javaagent:opentelemetry-javaagent.jar $JAVA_OPTS -jar jmuscles-rabbitmq-consumer-app-j8sb2713-1.0.jar" ]