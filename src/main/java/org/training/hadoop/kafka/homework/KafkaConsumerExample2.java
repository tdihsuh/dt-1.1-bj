package org.training.hadoop.kafka.homework;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


public class KafkaConsumerExample2 {
    //config
    public static Properties getConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "master:9092");
        props.put("group.id", "testGroup");
        props.put("enable.auto.commit", "true");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        return props;
    }

    public void consumeMessage() {
        String topic = "example1";
        Properties props = getConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        try {
            consumer.subscribe(Arrays.asList(topic));
            //read data
            ConsumerRecords<String, String> records = consumer.poll(10000);
            // Handle new records
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("name: " + Thread.currentThread().getName() + " ; topic: "
                        + record.topic() + " ; offset: " + record.offset() + " ; key: "
                        + record.key() + " ; value: " + record.value());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        KafkaConsumerExample2 example = new KafkaConsumerExample2();
        example.consumeMessage();
    }
}
