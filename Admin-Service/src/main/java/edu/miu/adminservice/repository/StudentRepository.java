package edu.miu.adminservice.repository;


import edu.miu.adminservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByUserNumber(String userNumber);

    @Query(value = "select max(user_number) from student", nativeQuery = true)
    String findLastUserNumber();
}
