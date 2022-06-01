package ch.flashcode.kafka.listener;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ch.flashcode.kafka.User;


@Service
public class KafkaConsumer {

    @KafkaListener(topics = "TestTopic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "TestTopic_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(List<User> user) {
        System.out.println("Consumed JSON Message: " + user);
    }
 
}
