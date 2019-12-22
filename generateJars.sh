#!/bin/bash
cd ./bioscoop-app-advertisement-schedule-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-api-gateway || exit
./mvnw package -DskipTests

cd ../bioscoop-app-catering-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-hall-mgmt-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-media-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-schedule-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-staff-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-statistics-service || exit
./mvnw package -DskipTests

cd ../bioscoop-app-tickets-service || exit
./mvnw package -DskipTests