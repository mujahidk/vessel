#!/bin/bash

echo Building question service.
cd question-service/
./mvnw clean package

echo Building titan application.
cd ../titan
./build

cd ..
echo Starting Docker compose
docker-compose up -d --build