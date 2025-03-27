package kafka.demoapp.controller;

import kafka.demoapp.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final KafkaProducerService kafkaProducerService;

    // 단순 퍼블리시
    @RequestMapping("/publish")
    public String publish(String message) {
        kafkaProducerService.send(message);
        return "published message: " + message;
    }

    // 퍼블리시 + 콜백
    @RequestMapping("/publish2")
    public String publishWithCallback(String message) {
        kafkaProducerService.sendWithCallback(message);
        return "published a message with callback: " + message;
    }

    // JSON으로 퍼블리시 + 콜백
//    @RequestMapping("/publish3")
//    public String publishJson(MyMessage myMessage) {
//        kafkaProducerService.sendJson(myMessage);
//    }
}
