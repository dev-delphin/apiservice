#Build
FROM openjdk:20-ea-20-jdk AS builder
WORKDIR /src
COPY ./src .
RUN javac ./apireq/*.java
RUN jar cvf ./api_service.jar ./apireq/*.class
RUN jar uvfm ./api_service.jar ./MANIFEST.MF

#Runner
FROM openjdk:20-ea-20-jdk
# WORKDIR /app
COPY --from=builder /src/api_service.jar .
ENTRYPOINT [ "java", "-jar", "/api_service.jar" ]