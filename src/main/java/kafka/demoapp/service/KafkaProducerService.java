package kafka.demoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final static String TOPIC_NAME = "my-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    public void sendWithCallback(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent " + message + " offset:" + result.getRecordMetadata().offset());
            } else {
                ex.printStackTrace();
            }
        });
    }
}
