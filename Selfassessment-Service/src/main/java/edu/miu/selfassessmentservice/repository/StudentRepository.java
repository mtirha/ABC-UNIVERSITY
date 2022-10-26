package edu.miu.selfassessmentservice.repository;




import edu.miu.selfassessmentservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentNumber(String studentNumber);

}
