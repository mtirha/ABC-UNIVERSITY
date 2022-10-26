package edu.miu.selfassessmentservice.integration;


import edu.miu.dto.StudentDto;
import edu.miu.selfassessmentservice.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class StudentReceiver {


    @Autowired
    private IStudentService studentService;

    @KafkaListener(topics = "studentTopic", groupId = "gid3")
    public void receive(@Payload StudentDto studentDto){
        studentService.handleRecord(studentDto);
    }
}
