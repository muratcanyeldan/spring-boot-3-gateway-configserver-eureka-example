FROM maven:3.9.8 AS maven
LABEL authors="Muratcan Yeldan"

WORKDIR /opt/config
COPY . /opt/config
RUN mvn clean install

FROM eclipse-temurin:21.0.4_7-jre-alpine

ARG JAR_FILE=ConfigServer.jar

WORKDIR /opt/config

COPY --from=maven /opt/config/target/${JAR_FILE} /opt/config/

ENTRYPOINT ["java","-jar","ConfigServer.jar"]