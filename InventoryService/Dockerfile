FROM maven:3.9.8 AS maven
LABEL authors="Muratcan Yeldan"

WORKDIR /opt/inventory
COPY . /opt/inventory
RUN mvn clean install

FROM eclipse-temurin:21.0.4_7-jre-alpine

ARG JAR_FILE=InventoryService.jar

WORKDIR /opt/inventory

COPY --from=maven /opt/inventory/target/${JAR_FILE} /opt/inventory/

ENTRYPOINT ["java","-jar","InventoryService.jar"]