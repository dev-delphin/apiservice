FROM openjdk:19
COPY ./src/apireq/ .
WORKDIR /apireq
ENTRYPOINT ["Java", "Api"]