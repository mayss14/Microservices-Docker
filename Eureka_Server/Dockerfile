FROM maven:3.8.4-openjdk-17 AS builder
EXPOSE 8761
ADD ./target/server.jar server.jar
CMD ["java","-jar","server.jar"]