package edu.miu.registrarservice.integration;


import edu.miu.dto.StudentDto;
import edu.miu.registrarservice.domain.Student;
import edu.miu.registrarservice.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class StudentReceiver {


    @Autowired
    private IStudentService studentService;

    @KafkaListener(topics = "studentTopic", groupId = "gid1")
    public void receive(@Payload StudentDto studentDto){
        studentService.handleRecord(studentDto);
    }
}
