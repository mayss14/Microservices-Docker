FROM maven:3.8.4-openjdk-17 AS builder
EXPOSE 8083
ADD ./target/car.jar car.jar
CMD ["java","-jar","car.jar"]