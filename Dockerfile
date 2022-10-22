#Build
FROM openjdk:20-ea-20-jdk AS build
WORKDIR /src
COPY ./src .
RUN javac ./apireq/*.java
ENTRYPOINT ["jar", "Api"]

#Runner
FROM openjdk:20-ea-20-jdk
