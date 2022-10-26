package edu.miu.adminservice.integration;

import edu.miu.dto.FacultyDto;
import edu.miu.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class FacultySender {
    
    @Autowired
    private KafkaTemplate<String, FacultyDto> kafkaTemplate;

    @Value("${app.topic.faculty}")
    private String topic;

    public void send(FacultyDto facultyDto){
        kafkaTemplate.send(topic, facultyDto);
    }
}
