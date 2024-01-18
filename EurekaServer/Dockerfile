FROM maven:3.9.6 AS maven
LABEL authors="Muratcan Yeldan"

WORKDIR /opt/eureka
COPY . /opt/eureka
RUN mvn clean install

FROM eclipse-temurin:21.0.1_12-jre-alpine

ARG JAR_FILE=eureka.jar

WORKDIR /opt/eureka

COPY --from=maven /opt/eureka/target/${JAR_FILE} /opt/eureka/

ENTRYPOINT ["java","-jar","eureka.jar"]