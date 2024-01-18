FROM maven:3.9.6 AS maven
LABEL authors="Muratcan Yeldan"

WORKDIR /opt/gateway
COPY . /opt/gateway
RUN mvn clean install

FROM eclipse-temurin:21.0.1_12-jre-alpine

ARG JAR_FILE=gateway-service.jar

WORKDIR /opt/gateway

COPY --from=maven /opt/gateway/target/${JAR_FILE} /opt/gateway/

ENTRYPOINT ["java","-jar","gateway-service.jar"]