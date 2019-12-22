FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/bioscoop-app-catering-service-1.0-SNAPSHOT.jar /usr/src/bioscoop/catering-service-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "catering-service-1.0-SNAPSHOT.jar"]

