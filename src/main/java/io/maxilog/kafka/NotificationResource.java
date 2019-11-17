package io.maxilog.kafka;

import io.maxilog.NotificationKafka;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.eclipse.microprofile.reactive.messaging.Incoming;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;


@Path("/notifications")
public class NotificationResource {

    @Inject
    @Channel("notification")
    Emitter<NotificationKafka> kafkaEmitter;

    @GET
    @Path("/notify")
    @Produces(MediaType.APPLICATION_JSON)
    public String notifyKafka() {
        kafkaEmitter.send(new NotificationKafka("Hello from kafka"));
        return "Message sent successfully to Kafka topic";
    }

    @Incoming("input")
    public CompletionStage consumeKafkaNotification(KafkaMessage<String, NotificationKafka> message) {
        System.out.println(message.getPayload());
        return message.ack();
    }
}