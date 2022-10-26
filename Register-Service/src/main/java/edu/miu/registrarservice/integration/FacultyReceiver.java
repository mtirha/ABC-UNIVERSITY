package edu.miu.registrarservice.integration;


import edu.miu.dto.FacultyDto;
import edu.miu.registrarservice.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FacultyReceiver {

    @Autowired
    private FacultyService facultyService;

    @KafkaListener(topics = "facultyTopic", groupId = "gid1")
    public void receive(@Payload FacultyDto facultyDto){
        facultyService.handleRecord(facultyDto);
    }
}
