#---------------------------------------------------------#
#                                                         #
# Stage 1: Create Build Image                             #
#                                                         #
#---------------------------------------------------------#
FROM openjdk:8-jdk-alpine3.7 AS builder
RUN java -version
COPY . /usr/src/myapp/
WORKDIR /usr/src/myapp/
RUN apk --no-cache add maven && mvn --version
RUN mvn package -Dmaven.test.skip=true

#---------------------------------------------------------#
#                                                         #
# Stage 2: Create Container Executable                    #
#                                                         #
#---------------------------------------------------------#
FROM openjdk:8-jre-alpine3.7
WORKDIR /root/
COPY --from=builder /usr/src/myapp/target/app.jar .

EXPOSE 6030
ENTRYPOINT ["java", "-jar", "./app.jar"]
