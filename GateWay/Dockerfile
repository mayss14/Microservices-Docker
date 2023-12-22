FROM maven:3.8.4-openjdk-17 AS builder
EXPOSE 8888
ADD ./target/gateway.jar gateway.jar
CMD ["java","-jar","gateway.jar"]