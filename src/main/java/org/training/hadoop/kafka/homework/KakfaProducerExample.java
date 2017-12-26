package org.training.hadoop.kafka.homework;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class KakfaProducerExample
{
    public void produceMessage()
    {
        Properties props = getConfig();
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<String, String>("example1", "1", "Hello world"));
        producer.send(new ProducerRecord<String, String>("example1", "2", "Hello java"));
        producer.send(new ProducerRecord<String, String>("example1", "3", "Hello food"));
        producer.send(new ProducerRecord<String, String>("example1", "4", "Hello tomorrow"));

        producer.close();
    }

    // config
    public Properties getConfig() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "master:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public static void main(String[] args) {
        KakfaProducerExample example = new KakfaProducerExample();
        example.produceMessage();
    }
}
