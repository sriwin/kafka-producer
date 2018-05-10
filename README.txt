https://creativedata.atlassian.net/wiki/spaces/SAP/pages/83207970/Java+-+Producer+Consumer+Kafka
https://github.com/saagie/example-talend-java-kafka-producer/blob/master/src/main/java/Example_Java_Kafka_Producer.java




Start ZooKeeper Server.
    From confluent-3.0.1\bin\windows directory run below command. zookeeper-server-start.bat ....\etc\kafka\zookeeper.properties
Start Kafka Server.
    kafka-server-start.bat ....\etc\kafka\server.properties
Start Schema Registry:
    schema-registry-start.bat ....\etc\schema-registry\schema-registry.properties
Start producer.
    kafka-console-producer.bat --broker-list localhost:9092 --topic text.test
Start Consumer.
    kafka-console-consumer.bat --topic text.test --from-beginning --zookeeper localhost:2181
Then start pumping messages from producer and you should receive it on consumer.
