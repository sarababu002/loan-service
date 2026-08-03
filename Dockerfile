FROM eclipse-temurin:21-jre

COPY build/libs/loan-service.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]