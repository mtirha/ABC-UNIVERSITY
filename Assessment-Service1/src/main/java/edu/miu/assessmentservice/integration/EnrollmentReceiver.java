package edu.miu.assessmentservice.integration;


import edu.miu.assessmentservice.service.IEnrollmentService;
import edu.miu.dto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentReceiver {

    @Autowired
    private IEnrollmentService enrollmentService;

    @KafkaListener(topics = "enrollmentTopic", groupId = "gid2")
    public void receive(@Payload EnrollmentDto enrollementDto){
        enrollmentService.handleRecord(enrollementDto);
    }
}
