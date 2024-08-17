FROM maven:3.9.8 AS maven
LABEL authors="Muratcan Yeldan"

WORKDIR /opt/eureka
COPY . /opt/eureka
RUN mvn clean install

FROM eclipse-temurin:21.0.4_7-jre-alpine

ARG JAR_FILE=Eureka.jar

WORKDIR /opt/eureka

COPY --from=maven /opt/eureka/target/${JAR_FILE} /opt/eureka/

ENTRYPOINT ["java","-jar","Eureka.jar"]