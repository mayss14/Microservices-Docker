FROM maven:3.8.4-openjdk-17 AS builder
EXPOSE 8082
ADD ./target/client.jar client.jar
CMD ["java","-jar","client.jar"]