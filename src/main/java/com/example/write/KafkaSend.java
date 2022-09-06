package com.example.write;

import com.example.write.model.Data;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaSend {

    KafkaTemplate<String, String> kafkaTemplate;

    public boolean send(String string) {
        try {
            kafkaTemplate.send("Data_Delivery", string);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
