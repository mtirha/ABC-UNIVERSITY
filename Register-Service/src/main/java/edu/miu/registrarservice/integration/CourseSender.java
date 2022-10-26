package edu.miu.registrarservice.integration;

import edu.miu.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CourseSender {
    
    @Autowired
    private KafkaTemplate<String, CourseDto> kafkaTemplate;

    @Value("${app.topic.course}")
    private String topic;

    public void send(CourseDto courseDto){
        kafkaTemplate.send(topic, courseDto);
    }
}
