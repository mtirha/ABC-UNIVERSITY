package edu.miu.assessmentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class AssessmentServiceApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(AssessmentServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Welcome to The Assessment Microservice Application");
        System.out.println("For ABC University System ");
    }
}
