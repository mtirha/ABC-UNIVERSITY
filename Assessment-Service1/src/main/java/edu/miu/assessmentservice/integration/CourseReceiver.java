package edu.miu.assessmentservice.integration;


import edu.miu.assessmentservice.service.ICourseService;
import edu.miu.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CourseReceiver {

    @Autowired
    private ICourseService courseService;

    @KafkaListener(topics = "courseTopic", groupId = "gid2")
    public void receive(@Payload CourseDto courseDto){
        courseService.handleRecord(courseDto);
    }
}
