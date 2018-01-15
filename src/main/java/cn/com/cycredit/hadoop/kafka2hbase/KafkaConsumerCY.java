package cn.com.cycredit.hadoop.kafka2hbase;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


public class KafkaConsumerCY
{
    //config
    public static Properties getConfig()
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.3.2.97:9092");
        props.put("group.id", "testGroup");
        props.put("enable.auto.commit", "true");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "300");
        props.put("auto.offset.reset", "earliest");
        return props;
    }

    public void transportMessage(String topicName , int threadNum)
    {
        // launch 3 threads to consume

        int numConsumers = threadNum;
        final String topic = topicName;
        final ExecutorService executor = Executors.newFixedThreadPool(numConsumers);
        final List<KafkaTransportRunner> consumers = new ArrayList<KafkaTransportRunner>();
        for (int i = 0; i < numConsumers; i++) {
            KafkaTransportRunner consumer = new KafkaTransportRunner(topic);
            consumers.add(consumer);
            executor.submit(consumer);
        }

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                for (KafkaTransportRunner consumer : consumers) {
                    consumer.shutdown();
                }
                executor.shutdown();
                try {
                    executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Thread to consume kafka data
    public static class KafkaTransportRunner
            implements Runnable
    {
        private final AtomicBoolean closed = new AtomicBoolean(false);
        private final KafkaConsumer<String, String> consumer;
        private final String topic;

        public KafkaTransportRunner(String topic)
        {
            Properties props = getConfig();
            consumer = new KafkaConsumer<String, String>(props);
            this.topic = topic;
        }


        public void run()
        {
            try {
                // subscribe
                consumer.subscribe(Arrays.asList(topic));
                while (!closed.get()) {

                    System.out.println("name: " + Thread.currentThread().getName() + " once poll begin!=============================================================once poll begin!");
                    //read data
                    ConsumerRecords<String, String> records = consumer.poll(10000);
                    // Handle new records
                    handleRecord(records);

                }
            }
            catch (WakeupException e) {
                // Ignore exception if closing
                if (!closed.get()) {
                    throw e;
                }
            }
            finally {
                consumer.close();
            }
        }

        public void handleRecord(ConsumerRecords<String, String> records){
            // TODO 123

            try {
                WriteToHBaseCY.asyncBatchPut(TableInformationCY.getHBaseConfiguration(),records,topic);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // Shutdown hook which can be called from a separate thread
        public void shutdown()
        {
            closed.set(true);
            consumer.wakeup();
        }
    }

    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.err.println("Usage: wordcount <topicName> <threadNum>");
            System.exit(2);
        }
        KafkaConsumerCY example = new KafkaConsumerCY();
        example.transportMessage(args[0],Integer.parseInt(args[1]));
    }
}
