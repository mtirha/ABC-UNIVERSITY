package edu.miu.registrarservice.repository;

import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Enrollment findByEnrollNumber(String enrollNumber);

    @Query(value = "select Enrollment.* from Enrollment inner join Student on Enrollment.student_id = Student.id " +
            "where Student.student_number = :studentNumber", nativeQuery = true)
    List<Enrollment> getAllByStudent(String studentNumber);
}
