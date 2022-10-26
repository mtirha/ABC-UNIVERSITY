package edu.miu.adminservice.integration;

import edu.miu.dto.StudentDto;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.Consumed;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentSender {
    
    @Autowired
    private KafkaTemplate<String, StudentDto> kafkaTemplate;
    
    @Value("${app.topic.student}")
    private String topic;

    public void send(StudentDto studentDto){
        kafkaTemplate.send(topic, studentDto);
    }
}
