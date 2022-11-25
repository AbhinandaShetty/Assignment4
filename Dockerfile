FROM openjdk:latest
           VOLUME /tmp 
           EXPOSE 8080 
           ADD target/Mobile-0.0.1-SNAPSHOT.jar app.jar
           ENTRYPOINT ["java","-jar","/app.jar"]