FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/bioscoop-app-tickets-service-0.0.1-SNAPSHOT.jar /usr/src/bioscoop/tickets-service-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "tickets-service-1.0-SNAPSHOT.jar"]

