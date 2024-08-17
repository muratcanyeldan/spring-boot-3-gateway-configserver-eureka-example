FROM maven:3.9.8 AS maven
LABEL authors="Muratcan Yeldan"

WORKDIR /opt/gateway
COPY . /opt/gateway
RUN mvn clean install

FROM eclipse-temurin:21.0.4_7-jre-alpine

ARG JAR_FILE=GatewayService.jar

WORKDIR /opt/gateway

COPY --from=maven /opt/gateway/target/${JAR_FILE} /opt/gateway/

ENTRYPOINT ["java","-jar","GatewayService.jar"]