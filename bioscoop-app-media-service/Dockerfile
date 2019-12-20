FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/media-service-1.0-SNAPSHOT.jar /usr/src/bioscoop/media-service-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "media-service-1.0-SNAPSHOT.jar"]

