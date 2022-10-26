package edu.miu.assessmentservice.repository;




import edu.miu.assessmentservice.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentNumber(String studentNumber);

}
