package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class ProducerTest {

    @Test
    void sendMessageWithoutKey() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:29092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {

            for(int i = 0; i < 10; i++) {
                log.info("Sending message");
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>("topic-1", "Hello World - " + UUID.randomUUID());
                Future<RecordMetadata> recordMetadataFuture = producer.send(producerRecord);
                RecordMetadata recordMetadata = recordMetadataFuture.get();
                log.info("Sent message");
                log.info("recordMetadata={}", recordMetadata);
                Thread.sleep(1000 * 10);
            }

        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
