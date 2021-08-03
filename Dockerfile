FROM gradle AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk
EXPOSE 8000
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/ServicioWebREST-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/app/ServicioWebREST-0.0.1-SNAPSHOT.jar"]