package kafka.demoapp.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final String TOPIC_NAME = "my-topic";

    @KafkaListener(topics = TOPIC_NAME)
    public void listenMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
