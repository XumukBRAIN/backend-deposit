FROM maven:3.8.4-openjdk-17-slim AS builder

WORKDIR /usr/src/amusic-new-backend-deposit

COPY . .

RUN mvn clean install -Dmaven.test.skip

#app
FROM openjdk:17-alpine3.14

#WORKDIR /app

COPY --from=builder /usr/src/amusic-new-backend-deposit/target/DepositService*.jar /app/backend-deposit.jar

CMD ["java", "-jar", "/app/backend-deposit.jar"]

