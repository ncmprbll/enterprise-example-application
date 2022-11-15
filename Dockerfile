FROM maven:3.8.6-openjdk-18 as build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM amazoncorretto:8-alpine3.13
COPY --from=build /home/app/target/enterprise-example-application.jar /
ENTRYPOINT ["java", "-jar", "enterprise-example-application.jar"]
