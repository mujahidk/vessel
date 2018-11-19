#!/bin/bash

echo Building question service.
cd question-service/
./mvnw clean package

cd ..
echo Starting Docker compose
docker-compose up -d --build