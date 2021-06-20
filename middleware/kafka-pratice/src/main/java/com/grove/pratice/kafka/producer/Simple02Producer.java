package com.grove.pratice.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Simple02Producer {
    private static final String brokerList = "192.168.0.112:9092";

    private static final String topic = "topic_demo";

    public static Properties initConfig() {
        Properties properties = new Properties();
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);
        properties.put("client.id","producer.demo.client");
        properties.put(ProducerConfig.RETRIES_CONFIG, 10);
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = initConfig();

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello world");

        try {
//            Future<RecordMetadata> send = producer.send(record);
//            RecordMetadata recordMetadata = send.get();

            // 异步
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        log.error("send message error", e);
                    }
                    if (recordMetadata != null) {
                        log.info("send message success");
                    }
                }
            });
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        producer.close(Duration.ofMillis(1000));
        log.info("end");
    }
}
