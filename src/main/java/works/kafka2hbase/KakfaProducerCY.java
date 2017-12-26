package works.kafka2hbase;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class KakfaProducerCY
{
    public void produceMessage()
    {
        Properties props = getConfig();
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 1000; i++) {
            System.out.println("i:" + i);
            producer.send(new ProducerRecord<String, String>("tag_oe", Integer.toString(i), Integer.toString(i)));
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }

    // config
    public Properties getConfig()
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.3.2.94:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public static void main(String[] args)
    {
        KakfaProducerCY example = new KakfaProducerCY();
        example.produceMessage();
    }
}
