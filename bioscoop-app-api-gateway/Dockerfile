FROM openjdk:8
RUN apt-get update && apt-get install -y curl
COPY ./target/bioscoop-app-api-gateway-1.0-SNAPSHOT.jar /usr/src/bioscoop/api-gateway-1.0-SNAPSHOT.jar

WORKDIR /usr/src/bioscoop
#CMD /bin/bash
CMD ["java", "-jar", "api-gateway-1.0-SNAPSHOT.jar"]

