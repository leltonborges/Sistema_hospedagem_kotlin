FROM gradle:7.4.2-jdk11 AS build
WORKDIR /app
COPY . .

RUN ["gradle", "clean", "build"]

FROM openjdk:11.0.15-jre-buster AS run
WORKDIR /app

COPY --from=build /app/build/libs/*-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java"]
CMD ["-jar", "app.jar"]
