package edu.miu.assessmentservice.integration;

import edu.miu.assessmentservice.service.ICourseOfferingService;
import edu.miu.dto.CourseOfferingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CourseOfferingReceiver {

    @Autowired
    private ICourseOfferingService courseOfferingService;

    @KafkaListener(topics = "offeringTopic", groupId = "gid2")
    public void receive(@Payload CourseOfferingDto courseOfferingDto){
        courseOfferingService.handleRecord(courseOfferingDto);
    }
}
