package edu.miu.registrarservice.configuration;

import java.util.HashMap;
import java.util.Map;

import edu.miu.dto.StudentDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
public class KafkaConsumerConfig
{
//    @Value(value = "${kafka.bootstrapAddress}")
//    private String bootstrapAddress;
//
//    @Value(value = "${student.topic.group.id}")
//    private String studentGroupId;
//
//    @Value(value = "${faculty.topic.group.id}")
//    private String facultyGroupId;
//
//    public ConsumerFactory<String, StudentDto> userConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, studentGroupId);
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "edu.miu.dto");
//        return new DefaultKafkaConsumerFactory<>(props,
//                new StringDeserializer(),
//                new JsonDeserializer<>(StudentDto.class));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, StudentDto>
//    userKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, StudentDto> factory
//                = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(userConsumerFactory());
//        return factory;
//    }
}