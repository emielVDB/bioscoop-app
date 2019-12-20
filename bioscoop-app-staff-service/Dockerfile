FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/staff-service-1.0-SNAPSHOT.jar /usr/src/bioscoop/staff-service-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "staff-service-1.0-SNAPSHOT.jar"]

