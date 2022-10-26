package edu.miu.registrarservice.integration;


import edu.miu.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentSender {
    
    @Autowired
    private KafkaTemplate<String, EnrollmentDto> kafkaTemplate;

    @Value("${app.topic.enrollment}")
    private String topic;

    public void send(EnrollmentDto enrollmentDto){
        kafkaTemplate.send(topic, enrollmentDto);
    }
}
