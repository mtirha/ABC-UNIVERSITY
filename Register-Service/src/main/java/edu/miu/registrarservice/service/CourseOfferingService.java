package edu.miu.registrarservice.service;

import edu.miu.dto.CourseOfferingAdapter;
import edu.miu.dto.CourseOfferingDto;
import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.integration.CourseOfferingSender;
import edu.miu.registrarservice.repository.CourseOfferingRepository;
import edu.miu.registrarservice.repository.CourseRepository;
import edu.miu.registrarservice.domain.Faculty;
import edu.miu.registrarservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CourseOfferingService implements ICourseOfferingService{

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private CourseOfferingSender courseOfferingSender;

    public CourseOffering create(String courseNumber, String facultyNumber, CourseOffering courseOffering) {
        Course course = courseRepository.findByCourseNumber(courseNumber);
//        courseRepository.saveAndFlush(course);
        Faculty faculty = facultyRepository.findByFacultyNumber(facultyNumber);
//        facultyRepository.saveAndFlush(faculty);
        courseOffering.setCourse(course);
        courseOffering.setFaculty(faculty);
        courseOffering.setOfferNumber(course.getCourseNumber() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear());
        courseOfferingRepository.save(courseOffering);

        CourseOfferingDto courseOfferingDto = CourseOfferingAdapter.toCourseOfferingDto(courseOffering);
        courseOfferingSender.send(courseOfferingDto);

        return courseOffering;
    }
    public CourseOffering update(String offerNumber, CourseOffering courseOffering) {
        CourseOffering updated = courseOfferingRepository.findByOfferNumber(offerNumber);
        if(updated != null){
            updated.setCourse(courseOffering.getCourse());
            updated.setFaculty(courseOffering.getFaculty());
            updated.setCapacity(courseOffering.getCapacity());
            updated.setStart(courseOffering.getStart());
            updated.setEnd(courseOffering.getEnd());
            updated.setRoomNumber(courseOffering.getRoomNumber());
            updated.setTerm(courseOffering.getTerm());
            courseOfferingRepository.save(updated);

            CourseOfferingDto courseOfferingDto = CourseOfferingAdapter.toCourseOfferingDto(updated);
            courseOfferingSender.send(courseOfferingDto);

        }
        return updated;
    }
    public List<CourseOffering> getAllByFaculty(String facultyNumber) {
        return courseOfferingRepository.getAllByFaculty(facultyNumber);
    }
    public Optional<CourseOffering> getOne(long id) {
        return courseOfferingRepository.findById(id);
    }

    @Override
    public CourseOffering getByOfferNumber(String offerNumber) {
        return courseOfferingRepository.findByOfferNumber(offerNumber);
    }

}
