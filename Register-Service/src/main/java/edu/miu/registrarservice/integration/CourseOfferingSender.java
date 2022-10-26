package edu.miu.registrarservice.integration;


import edu.miu.dto.CourseOfferingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CourseOfferingSender {
    
    @Autowired
    private KafkaTemplate<String, CourseOfferingDto> kafkaTemplate;

    @Value("${app.topic.offering}")
    private String topic;

    public void send(CourseOfferingDto courseOfferingDto){
        kafkaTemplate.send(topic, courseOfferingDto);
    }
}
