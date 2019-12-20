FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/bioscoop-app-hall-mgmt-service-1.0-SNAPSHOT.jar /usr/src/bioscoop/hall-service-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "hall-service-1.0-SNAPSHOT.jar"]

