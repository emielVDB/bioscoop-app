FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/bioscoop-app-advertisement-schedule-service-0.0.1-SNAPSHOT.jar /usr/src/bioscoop/advertisement-service-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "advertisement-service-1.0-SNAPSHOT.jar"]

