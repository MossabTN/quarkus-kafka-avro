Quarkus Kafka  with SchemaRegistry
========================

This project illustrates how you can interact with Apache Kafka using MicroProfile Reactive Messaging.

## Kafka cluster

First you need a Kafka cluster and schema registry. You can follow the instructions from the [Confluent Docker Image for Schema Registry](https://hub.docker.com/r/confluentinc/cp-schema-registry/) or run `./src/main/docker/docker-compose up` if you have docker installed on your machine.

## Start the application

The application can be started using: 

```bash
./mvnw compile quarkus:dev
```  

Then, open your browser to `http://localhost:8080/notifications/notify`, to send message via kafka.

## Running in native

You can compile the application into a native binary using (NOT WORKING):

`mvn clean package -Pnative`

and run with:

`./target/kafka-quickstart-1.0-SNAPSHOT-runner` 

## TODO
fix build native