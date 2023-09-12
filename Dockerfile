FROM openjdk:17
WORKDIR /app
ENV PORT 8085
EXPOSE 8085
COPY target/*.jar /app/hello-world.jar
ENTRYPOINT exec java $JAVA_OPTS -jar hello-world.jar