package edu.miu.assessmentservice.integration;


import edu.miu.dto.FacultyDto;
import edu.miu.assessmentservice.service.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FacultyReceiver {

    @Autowired
    private IFacultyService facultyService;

    @KafkaListener(topics = "facultyTopic", groupId = "gid2")
    public void receive(@Payload FacultyDto facultyDto){
        facultyService.handleRecord(facultyDto);
    }
}
