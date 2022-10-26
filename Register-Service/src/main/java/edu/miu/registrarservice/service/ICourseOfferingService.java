package edu.miu.registrarservice.service;

import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Faculty;
import edu.miu.registrarservice.repository.CourseOfferingRepository;
import edu.miu.registrarservice.repository.CourseRepository;
import edu.miu.registrarservice.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICourseOfferingService {

    CourseOffering create(String courseNumber, String facultyNumber, CourseOffering courseOffering) ;
    CourseOffering update(String offerNumber, CourseOffering courseOffering) ;
    List<CourseOffering> getAllByFaculty(String facultyNumber) ;
    Optional<CourseOffering> getOne(long id) ;
    CourseOffering getByOfferNumber(String offerNumber) ;

}
