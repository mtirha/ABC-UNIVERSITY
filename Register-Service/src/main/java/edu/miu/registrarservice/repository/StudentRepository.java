package edu.miu.registrarservice.repository;




import edu.miu.registrarservice.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentNumber(String studentNumber);

}
