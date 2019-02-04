#---------------------------------------------------------#
#                                                         #
# Stage 1: Setup Postgres Database                        #
#                                                         #
#---------------------------------------------------------#
FROM postgres:11
ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB world-db
ADD src/main/resources/scripts/*.sql /docker-entrypoint-initdb.d/
COPY docker-healthcheck /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-healthcheck
HEALTHCHECK CMD ["docker-healthcheck"]
EXPOSE 5030

#---------------------------------------------------------#
#                                                         #
# Stage 2: Create Build Image                             #
#                                                         #
#---------------------------------------------------------#
FROM openjdk:8-jdk-alpine3.7 AS builder
RUN java -version
COPY . /usr/src/myapp/
WORKDIR /usr/src/myapp/
RUN apk --no-cache add maven && mvn --version
RUN mvn package

#---------------------------------------------------------#
#                                                         #
# Stage 3: Create Container Executable                    #
#                                                         #
#---------------------------------------------------------#
FROM openjdk:8-jre-alpine3.7
WORKDIR /root/
COPY --from=builder /usr/src/myapp/target/app.jar .

EXPOSE 6030
ENTRYPOINT ["java", "-jar", "./app.jar"]
