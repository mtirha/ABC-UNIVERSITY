package edu.miu.registrarservice.repository;

import edu.miu.registrarservice.domain.Course;
import edu.miu.registrarservice.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {

    CourseOffering findByOfferNumber(String facultyNumber);

    @Query(value = "select Course_Offering.* from Course_Offering inner join Faculty on Course_Offering.faculty_id = Faculty.id " +
            "where Faculty.faculty_number = :facultyNumber", nativeQuery = true)
    List<CourseOffering> getAllByFaculty(String facultyNumber);
}
