#!/bin/bash
./mvnw package 
docker build -t reciperestjava . 
docker run -p 8090:8090 reciperestjava:latest --rm
