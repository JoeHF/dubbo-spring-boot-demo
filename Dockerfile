FROM java:8
VOLUME /tmp
ADD dubbo-provider/target/dubbo-spring-boot-provider-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 12345
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]