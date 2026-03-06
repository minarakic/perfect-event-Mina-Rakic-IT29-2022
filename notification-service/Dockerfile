FROM gradle:8.14.2-jdk17 AS build

WORKDIR /app
COPY . .

RUN gradle build --no-daemon

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","app.jar"]